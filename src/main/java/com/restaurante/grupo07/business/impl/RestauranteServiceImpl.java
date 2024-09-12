package com.restaurante.grupo07.business.impl;

import com.restaurante.grupo07.api.request.AddRestauranteDto;
import com.restaurante.grupo07.api.response.RestauranteDto;
import com.restaurante.grupo07.api.mapper.RestauranteMapper;
import com.restaurante.grupo07.infrastructure.model.Restaurante;
import com.restaurante.grupo07.infrastructure.repository.RestauranteRepository;
import com.restaurante.grupo07.business.RestauranteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class RestauranteServiceImpl implements RestauranteService {

    @Autowired
    private RestauranteRepository restauranteRepository;

    @Autowired
    private RestauranteMapper restauranteMapper;

    @Override
    public RestauranteDto adicionar(AddRestauranteDto addRestauranteDto) {
        return restauranteMapper.toDto(restauranteRepository.save(restauranteMapper.toEntity(addRestauranteDto)));
    }

    @Override
    public RestauranteDto buscarPorId(Long id) {
        return restauranteRepository.findById(id)
                .map(entity -> restauranteMapper.toDto(entity))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Restaurante não encontrado!"));
    }

    @Override
    public RestauranteDto atualizar(RestauranteDto restauranteDto) {
        return restauranteRepository.findById(restauranteDto.id())
            .map(entity -> {
                entity.setNome(restauranteDto.nome());
                entity.setCnpj(restauranteDto.cnpj());
                entity.setEndereco(restauranteDto.endereco());
                entity.setContato(restauranteDto.contato());
                return restauranteMapper.toDto(restauranteRepository.save(entity));

        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Restaurante não encontrado!"));
    }

    @Override
    public void excluir(Long id) {
        Optional<Restaurante> restaurante = restauranteRepository.findById(id);

        if (restaurante.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Restaurante não encontrado!");
        }

        restauranteRepository.deleteById(id);
    }
}
