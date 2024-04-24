package com.restaurante.grupo07.service;

import java.util.List;

import com.restaurante.grupo07.model.Restaurante;
import com.restaurante.grupo07.resource.dto.RestauranteDto;

public interface RestauranteService {
    Restaurante adicionarRestaurante(RestauranteDto restauranteDto);
    Restaurante buscarRestaurantePorId(Long id);
    List<Restaurante> listarRestaurantes();
    Restaurante atualizarRestaurante(Long id, RestauranteDto restauranteDto);
    void excluirRestaurante(Long id);
}
