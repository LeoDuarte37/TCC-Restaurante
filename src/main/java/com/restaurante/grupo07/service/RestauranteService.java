package com.restaurante.grupo07.service;

import java.util.List;

import com.restaurante.grupo07.model.Restaurante;
import com.restaurante.grupo07.dto.RestauranteDto;
import org.springframework.http.ResponseEntity;

public interface RestauranteService {
    ResponseEntity<Restaurante> adicionar(RestauranteDto restauranteDto);
    ResponseEntity<Restaurante> buscarPorId(Long id);
    ResponseEntity<List<Restaurante>> listar();
    ResponseEntity<Restaurante> atualizar(RestauranteDto restauranteDto);
    void excluir(Long id);
}
