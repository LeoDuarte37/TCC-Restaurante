package com.restaurante.grupo07.business;

import com.restaurante.grupo07.api.request.AddRestauranteDto;
import com.restaurante.grupo07.api.response.RestauranteDto;

public interface RestauranteService {
    RestauranteDto adicionar(AddRestauranteDto addRestauranteDto);

    RestauranteDto buscarPorId(Long id);

    RestauranteDto atualizar(RestauranteDto restauranteDto);

    void excluir(Long id);
}
