package com.restaurante.grupo07.service.impl;

import com.restaurante.grupo07.dto.RestauranteDto;
import com.restaurante.grupo07.dto.mapper.RestauranteMapper;
import com.restaurante.grupo07.repository.RestauranteRepository;
import com.restaurante.grupo07.service.RestauranteService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RestauranteServiceImpl implements RestauranteService {

    @Autowired
    private final RestauranteRepository restauranteRepository;

    @Autowired
    private final RestauranteMapper restauranteMapper;

    @Override
    public RestauranteDto adicionar(RestauranteDto restauranteDto) {
        return null;
    }

    @Override
    public RestauranteDto buscarPorId(Long id) {
        return null;
    }

    @Override
    public List<RestauranteDto> listar() {
        return null;
    }

    @Override
    public RestauranteDto atualizar(RestauranteDto restauranteDto) {
        return null;
    }

    @Override
    public void excluir(Long id) {

    }
}
