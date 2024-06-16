package com.restaurante.grupo07.service.impl;

import com.restaurante.grupo07.dto.AtualizarCardapioDto;
import com.restaurante.grupo07.dto.categoria.AddCategoriaDto;
import com.restaurante.grupo07.dto.categoria.CategoriaDto;
import com.restaurante.grupo07.mapper.CategoriaMapper;
import com.restaurante.grupo07.model.Categoria;
import com.restaurante.grupo07.model.Restaurante;
import com.restaurante.grupo07.repository.CategoriaRepository;
import com.restaurante.grupo07.repository.RestauranteRepository;
import com.restaurante.grupo07.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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
        return categoriaRepository.findAllByRestauranteAndDisponivelTrue(restaurante)
                .stream()
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

        categoriaRepository.deleteById(id);
    }
}
