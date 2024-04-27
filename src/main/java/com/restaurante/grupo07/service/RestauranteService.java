package com.restaurante.grupo07.service;

import java.util.List;

import com.restaurante.grupo07.model.Restaurante;
import com.restaurante.grupo07.resource.dto.RestauranteDto;
import org.springframework.http.ResponseEntity;

public interface RestauranteService {
    ResponseEntity<Restaurante> adicionarRestaurante(RestauranteDto restauranteDto);
    ResponseEntity<Restaurante> buscarRestaurantePorId(Long id);
    ResponseEntity<List<Restaurante>> listarRestaurantes();
    ResponseEntity<Restaurante> atualizarRestaurante(Long id, RestauranteDto restauranteDto);
    void excluirRestaurante(Long id);
}
