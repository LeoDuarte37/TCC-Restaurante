package com.restaurante.grupo07.service;

import com.restaurante.grupo07.dto.AtualizarCardapioDto;
import com.restaurante.grupo07.dto.categoria.AddCategoriaDto;
import com.restaurante.grupo07.dto.categoria.CategoriaDto;

import java.util.List;

public interface CategoriaService {
    void adicionar(AddCategoriaDto addCategoriaDto);

    CategoriaDto buscarPorId(Long id);

    List<CategoriaDto> listarPorNome(String nome);

    List<CategoriaDto> listarPorRestaurante(Long restauranteId);

    List<CategoriaDto> listarDisponiveisPorRestaurante(Long restauranteId);

    CategoriaDto atualizar(AtualizarCardapioDto atualizarCardapioDto);

    void excluir(Long id);
}