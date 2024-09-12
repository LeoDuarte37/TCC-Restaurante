package com.restaurante.grupo07.business;

import com.restaurante.grupo07.api.request.AtualizarCardapioDto;
import com.restaurante.grupo07.api.request.AddCategoriaDto;
import com.restaurante.grupo07.api.response.CategoriaDto;

import java.util.List;

public interface CategoriaService {
    CategoriaDto adicionar(AddCategoriaDto addCategoriaDto);

    CategoriaDto buscarPorId(Long id);

    List<CategoriaDto> listarPorNome(String nome);

    List<CategoriaDto> listarPorRestaurante(Long restauranteId);

    List<CategoriaDto> listarDisponiveisPorRestaurante(Long restauranteId);

    CategoriaDto atualizar(AtualizarCardapioDto atualizarCardapioDto);

    void excluir(Long id);
}