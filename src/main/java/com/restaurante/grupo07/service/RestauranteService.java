package com.restaurante.grupo07.service;

import com.restaurante.grupo07.dto.restaurante.AddRestauranteDto;
import com.restaurante.grupo07.dto.restaurante.RestauranteDto;

public interface RestauranteService {
    RestauranteDto adicionar(AddRestauranteDto addRestauranteDto);

    RestauranteDto buscarPorId(Long id);

    RestauranteDto atualizar(RestauranteDto restauranteDto);

    void excluir(Long id);
}
