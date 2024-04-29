package com.restaurante.grupo07.service.impl;

import com.restaurante.grupo07.model.Restaurante;
import com.restaurante.grupo07.repository.RestauranteRepository;
import com.restaurante.grupo07.dto.RestauranteDto;
import com.restaurante.grupo07.service.RestauranteService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RestauranteServiceImpl implements RestauranteService {

    @Autowired
    private final RestauranteRepository restauranteRepository;
    @Override
    public ResponseEntity<Restaurante> adicionar(RestauranteDto restauranteDto) {
        return null;
    }

    @Override
    public ResponseEntity<Restaurante> buscarPorId(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<List<Restaurante>> listar() {
        return null;
    }

    @Override
    public ResponseEntity<Restaurante> atualizar(RestauranteDto restauranteDto) {
        return null;
    }

    @Override
    public void excluir(Long id) {

    }
}
