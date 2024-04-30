package com.restaurante.grupo07.service;

import java.util.List;

import com.restaurante.grupo07.dto.RestauranteDto;

public interface RestauranteService {
    RestauranteDto adicionar(RestauranteDto restauranteDto);
    RestauranteDto buscarPorId(Long id);
    List<RestauranteDto> listar();
    RestauranteDto atualizar(RestauranteDto restauranteDto);
    void excluir(Long id);
}
