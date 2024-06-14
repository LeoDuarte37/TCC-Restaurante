package com.restaurante.grupo07.service.impl;

import com.restaurante.grupo07.dto.ListarPorStatusDto;
import com.restaurante.grupo07.dto.LoginMesaDto;
import com.restaurante.grupo07.dto.MesaDto;
import com.restaurante.grupo07.dto.mapper.MesaMapper;
import com.restaurante.grupo07.enumeration.StatusMesa;
import com.restaurante.grupo07.model.Mesa;
import com.restaurante.grupo07.repository.MesaRepository;
import com.restaurante.grupo07.repository.RestauranteRepository;
import com.restaurante.grupo07.service.MesaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class MesaServiceImpl implements MesaService {

    @Autowired
    private MesaRepository mesaRepository;

    @Autowired
    private MesaMapper mesaMapper;

    @Autowired
    private RestauranteRepository restauranteRepository;


    @Override
    public MesaDto adicionar(MesaDto mesaDto) {
        if (restauranteRepository.existsById(mesaDto.restaurante().getId())){
            return mesaMapper.toDto(mesaRepository.save(mesaMapper.toEntity(mesaDto)));
        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Restaurante não encontrado!");
    }

    @Override
    public MesaDto buscarPorId(Long id) {
        return mesaRepository.findById(id)
                .map(entity -> mesaMapper.toDto(entity))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public MesaDto loginMesa(LoginMesaDto loginMesaDto) {
        UUID uuid = UUID.fromString(loginMesaDto.uuid());

        try {
            return mesaMapper.toDto(mesaRepository.findByRestaurante(uuid, loginMesaDto.numero()));
        } catch (NullPointerException e) {
            throw new RuntimeException("Mesa não encontrada!");
        }
    }

    @Override
    public List<MesaDto> listar() {
        return mesaRepository.findAll()
                .stream()
                .map(entity -> mesaMapper.toDto(entity))
                .collect(Collectors.toList());
    }

    @Override
    public List<MesaDto> listarPorRestaurante(Long restauranteId) {
        return mesaRepository.findAllByRestauranteOrderByNumero(restauranteId)
                .stream()
                .map(entity -> mesaMapper.toDto(entity))
                .collect(Collectors.toList());
    }

    @Override
    public List<MesaDto> listarPorRestauranteAndStatus(ListarPorStatusDto listarPorStatusDto) {
        StatusMesa statusMesa = StatusMesa.doStatus(listarPorStatusDto.status());

        return mesaRepository.findAllByRestauranteAndStatus(listarPorStatusDto.restauranteId(), statusMesa)
                .stream()
                .map(entity -> mesaMapper.toDto(entity))
                .collect(Collectors.toList());
    }

    @Override
    public List<MesaDto> listarChamandoGarcom(Long restauranteId) {
        return mesaRepository.findAllByChamarGarcomTrue(restauranteId)
                .stream()
                .map(entity -> mesaMapper.toDto(entity))
                .collect(Collectors.toList());
    }

    @Override
    public MesaDto atualizar(MesaDto mesaDto) {
        return mesaRepository.findById(mesaDto.id())
                .map(entity -> {
                    entity.setNumero(mesaDto.numero());
                    entity.setRestaurante(mesaDto.restaurante());
                    entity.setChamarGarcom(mesaDto.chamarGarcom());
                    entity.setStatus(StatusMesa.doStatus(mesaDto.status()));
                    return mesaMapper.toDto(mesaRepository.save(entity));

                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public MesaDto atualizarStatus(MesaDto mesaDto) {
        return mesaRepository.findById(mesaDto.id())
                .map(entity -> {
                    entity.setStatus(StatusMesa.doStatus(mesaDto.status()));
                    return mesaMapper.toDto(mesaRepository.save(entity));

                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public MesaDto atualizarChamarGarcom(MesaDto mesaDto) {
        return mesaRepository.findById(mesaDto.id())
                .map(entity -> {
                    entity.setChamarGarcom(mesaDto.chamarGarcom());
                    return mesaMapper.toDto(mesaRepository.save(entity));

                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public void excluir(Long id) {
        Optional<Mesa> mesa = mesaRepository.findById(id);

        if (mesa.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        mesaRepository.deleteById(id);
    }
}
