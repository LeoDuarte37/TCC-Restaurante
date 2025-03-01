package com.restaurante.grupo07.business.impl;

import com.restaurante.grupo07.api.request.AtualizarCardapioDto;
import com.restaurante.grupo07.api.request.AddCategoriaDto;
import com.restaurante.grupo07.api.response.CategoriaDto;
import com.restaurante.grupo07.infrastructure.repository.*;
import com.restaurante.grupo07.api.mapper.CategoriaMapper;
import com.restaurante.grupo07.infrastructure.model.Categoria;
import com.restaurante.grupo07.infrastructure.model.Produto;
import com.restaurante.grupo07.infrastructure.model.Restaurante;
import com.restaurante.grupo07.infrastructure.model.Subcategoria;
import com.restaurante.grupo07.business.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    private RestauranteRepository restauranteRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private CategoriaMapper categoriaMapper;

    @Autowired
    SubcategoriaRepository subcategoriaRepository;

    @Autowired
    ProdutoRepository produtoRepository;

    @Autowired
    PedidoRepository pedidoRepository;

    @Override
    public CategoriaDto adicionar(AddCategoriaDto addCategoriaDto) {
        Optional<Restaurante> restaurante = restauranteRepository.findById(addCategoriaDto.restauranteId());

        if (restaurante.isPresent()) {
            Categoria categoria = new Categoria(addCategoriaDto.nome(), addCategoriaDto.disponivel(), restaurante.get());
            return categoriaMapper.toDto(categoriaRepository.save(categoria));
        }

        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Restaurante não encontrado!");
    }

    @Override
    public CategoriaDto buscarPorId(Long id) {
        return categoriaRepository.findById(id)
                .map(entity -> categoriaMapper.toDto(entity))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public List<CategoriaDto> listarPorNome(String nome) {
        return categoriaRepository.findAllByNomeContainingIgnoreCase(nome)
                .stream()
                .map(entity -> categoriaMapper.toDto(entity))
                .collect(Collectors.toList());
    }

    @Override
    public List<CategoriaDto> listarPorRestaurante(Long restaurante) {
        return categoriaRepository.findAllByRestaurante(restaurante)
                .stream()
                .map(entity -> categoriaMapper.toDto(entity))
                .collect(Collectors.toList());
    }

    @Override
    public List<CategoriaDto> listarDisponiveisPorRestaurante(Long restaurante) {
        List<Categoria> categoriasDisponiveis = categoriaRepository.findAllByRestauranteAndDisponivelTrue(restaurante)
                .stream()
                .toList();

        for (Categoria categoria : categoriasDisponiveis) {
            List<Subcategoria> subcategoriasDisponiveis = subcategoriaRepository.findByDisponivelTrueAndCategoria(categoria);


            for (Subcategoria subcategoria : subcategoriasDisponiveis) {
                List<Produto> produtosDisponiveis = produtoRepository.findByDisponivelTrueAndSubcategoria(subcategoria);

                if (produtosDisponiveis.isEmpty()) {
                    categoria.setSubcategoria(new ArrayList<>());
                } else {
                    categoria.setSubcategoria(subcategoriasDisponiveis);
                    subcategoria.setProduto(produtosDisponiveis);
                }
            }
        }

        return categoriasDisponiveis.stream()
                .map(entity -> categoriaMapper.toDto(entity))
                .collect(Collectors.toList());
    }

    @Override
    public CategoriaDto atualizar(AtualizarCardapioDto atualizarCardapioDto) {

        return categoriaRepository.findById(atualizarCardapioDto.id())
                .map(entity -> {
                    entity.setNome(atualizarCardapioDto.nome());
                    entity.setDisponivel(atualizarCardapioDto.disponivel());
                    return categoriaMapper.toDto(categoriaRepository.save(entity));

                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public void excluir(Long id) {
        Optional<Categoria> categoria = categoriaRepository.findById(id);

        if (categoria.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        categoria.get().getSubcategoria()
                .stream()
                .map(subcategoria -> subcategoria.getProduto()
                       .stream()
                       .map(produto -> {
                           Long idProduto = produto.getId();
                           pedidoRepository.deleteAllByProduto(idProduto);
                           return null;
                       }));

        categoriaRepository.deleteById(id);
    }
}
