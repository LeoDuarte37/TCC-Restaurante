package com.restaurante.grupo07.service.impl;

import com.restaurante.grupo07.dto.mapper.ProdutoMapper;
import com.restaurante.grupo07.model.Produto;
import com.restaurante.grupo07.repository.CategoriaRepository;
import com.restaurante.grupo07.repository.ProdutoRepository;
import com.restaurante.grupo07.dto.ProdutoDto;
import com.restaurante.grupo07.service.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProdutoServiceImpl implements ProdutoService {

    @Autowired
    private final ProdutoRepository produtoRepository;

    @Autowired
    private final ProdutoMapper produtoMapper;

    @Autowired
    private final CategoriaRepository categoriaRepository;

    @Override
    public ProdutoDto adicionar(ProdutoDto produtoDto) {
        if (categoriaRepository.existsById(produtoDto.categoria().getId())) {
            return produtoMapper.toDto(produtoRepository.save(produtoMapper.toEntity(produtoDto)));
        }

        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Categoria não encontrada!");
    }

    @Override
    public ProdutoDto buscarPorId(Long id) {
        return produtoRepository.findById(id)
                .map(entity -> produtoMapper.toDto(entity))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public List<ProdutoDto> listar() {
        return produtoRepository.findAll()
                .stream()
                .map(entity -> produtoMapper.toDto(entity))
                .collect(Collectors.toList());
    }

    @Override
    public List<ProdutoDto> listarDisponiveis() {
        return produtoRepository.findByDisponivelTrue()
                .stream()
                .map(entity -> produtoMapper.toDto(entity))
                .collect(Collectors.toList());
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
        if (categoriaRepository.existsById(produtoDto.categoria().getId())) {
            return produtoRepository.findById(produtoDto.id())
                    .map(entity -> {
                        entity.setNome(produtoDto.nome());
                        entity.setDescricao(produtoDto.descricao());
                        entity.setFoto(produtoDto.foto());
                        entity.setValor(produtoDto.valor());
                        entity.setDisponivel(produtoDto.disponivel());
                        entity.setCategoria(produtoDto.categoria());
                        return produtoMapper.toDto(produtoRepository.save(entity));

                    }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado!"));
        }

        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Categoria não encontrada!");
    }

    @Override
    public ProdutoDto atualizarStatus(ProdutoDto produtoDto) {
        return produtoRepository.findById(produtoDto.id())
                .map(entity -> {
                    entity.setDisponivel(produtoDto.disponivel());
                    return produtoMapper.toDto(produtoRepository.save(entity));

                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado!"));
    }

    @Override
    public void excluir(Long id) {
        Optional<Produto> produto = produtoRepository.findById(id);

        if (produto.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado!");
        }

        produtoRepository.deleteById(id);
    }
}
