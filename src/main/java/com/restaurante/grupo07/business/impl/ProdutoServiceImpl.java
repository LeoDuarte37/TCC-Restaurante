package com.restaurante.grupo07.business.impl;

import com.restaurante.grupo07.api.request.AddProdutoDto;
import com.restaurante.grupo07.api.response.ProdutoDto;
import com.restaurante.grupo07.api.mapper.ProdutoMapper;
import com.restaurante.grupo07.infrastructure.model.Produto;
import com.restaurante.grupo07.infrastructure.model.Subcategoria;
import com.restaurante.grupo07.infrastructure.repository.PedidoRepository;
import com.restaurante.grupo07.infrastructure.repository.ProdutoRepository;
import com.restaurante.grupo07.infrastructure.repository.SubcategoriaRepository;
import com.restaurante.grupo07.business.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private ProdutoMapper produtoMapper;

    @Autowired
    private SubcategoriaRepository subcategoriaRepository;

    @Autowired
    private PedidoRepository pedidoRepository;

    @Override
    public ProdutoDto adicionar(AddProdutoDto addProdutoDto) {
        Optional<Subcategoria> subcategoria = subcategoriaRepository.findById(addProdutoDto.subcategoriaId());

        if (subcategoria.isPresent()) {
            Produto produto = new Produto(
                    addProdutoDto.nome(),
                    addProdutoDto.descricao(),
                    addProdutoDto.foto(),
                    addProdutoDto.valor(),
                    addProdutoDto.disponivel(),
                    subcategoria.get()
            );
            return produtoMapper.toDto(produtoRepository.save(produto));
        }

        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Subcategoria não encontrada!");
    }

    @Override
    public ProdutoDto buscarPorId(Long id) {
        return produtoRepository.findById(id)
                .map(entity -> produtoMapper.toDto(entity))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public List<ProdutoDto> listarPorNome(String nome) {
        return produtoRepository.findAllByNomeContainingIgnoreCase(nome)
                .stream()
                .map(entity -> produtoMapper.toDto(entity))
                .collect(Collectors.toList());
    }

    @Override
    public ProdutoDto atualizar(ProdutoDto produtoDto) {
        if (subcategoriaRepository.existsById(produtoDto.subcategoria().getId())) {
            return produtoRepository.findById(produtoDto.id())
                    .map(entity -> {
                        entity.setNome(produtoDto.nome());
                        entity.setDescricao(produtoDto.descricao());
                        entity.setFoto(produtoDto.foto());
                        entity.setValor(produtoDto.valor());
                        entity.setDisponivel(produtoDto.disponivel());
                        return produtoMapper.toDto(produtoRepository.save(entity));

                    }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado!"));
        }

        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Categoria não encontrada!");
    }

    @Override
    public void excluir(Long id) {
        Optional<Produto> produto = produtoRepository.findById(id);

        if (produto.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado!");
        }

        pedidoRepository.deleteAllByProduto(id);
        produtoRepository.deleteById(id);
    }
}
