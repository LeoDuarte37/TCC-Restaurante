package com.restaurante.grupo07.service.impl;

import com.restaurante.grupo07.dto.RestauranteDto;
import com.restaurante.grupo07.dto.mapper.RestauranteMapper;
import com.restaurante.grupo07.model.Restaurante;
import com.restaurante.grupo07.repository.RestauranteRepository;
import com.restaurante.grupo07.service.RestauranteService;
import com.restaurante.grupo07.util.StringToUUIDConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service

public class RestauranteServiceImpl implements RestauranteService {

    @Autowired
    private RestauranteRepository restauranteRepository;

    @Autowired
    private RestauranteMapper restauranteMapper;

    @Autowired
    private StringToUUIDConverter stringToUUIDConverter;

    @Override
    public RestauranteDto adicionar(RestauranteDto restauranteDto) {
        return restauranteMapper.toDto(restauranteRepository.save(restauranteMapper.toEntity(restauranteDto)));
    }

    @Override
    public RestauranteDto buscarPorId(Long id) {
        return restauranteRepository.findById(id)
                .map(entity -> restauranteMapper.toDto(entity))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Restaurante não encontrado!"));
    }

    @Override
    public List<RestauranteDto> listar() {
        return restauranteRepository.findAll()
                .stream()
                .map(entity -> restauranteMapper.toDto(entity))
                .collect(Collectors.toList());
    }

    @Override
    public RestauranteDto atualizar(RestauranteDto restauranteDto) {
        UUID uuid = stringToUUIDConverter.convert(restauranteDto.uuid());

        Long id = restauranteRepository.findRestauranteByUuid(uuid).getId();

        return restauranteRepository.findById(id)
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
