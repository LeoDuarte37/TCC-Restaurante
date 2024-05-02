package com.restaurante.grupo07.service.impl;

import com.restaurante.grupo07.dto.mapper.PerfilMapper;
import com.restaurante.grupo07.model.Perfil;
import com.restaurante.grupo07.repository.PerfilRepository;
import com.restaurante.grupo07.dto.PerfilDto;
import com.restaurante.grupo07.service.PerfilService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PerfilServiceImpl implements PerfilService {

    @Autowired
    private final PerfilRepository perfilRepository;

    @Autowired
    private final PerfilMapper perfilMapper;

    @Override
    public PerfilDto adicionar(PerfilDto perfilDto) {
        return perfilMapper.toDto(perfilRepository.save(perfilMapper.toEntity(perfilDto)));
    }

    @Override
    public PerfilDto buscarPorId(Long id) {
        return perfilRepository.findById(id)
                .map(entity -> perfilMapper.toDto(entity))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Perfil não encontrado!"));
    }

    @Override
    public List<PerfilDto> listar() {
        return perfilRepository.findAll()
                .stream()
                .map(entity -> perfilMapper.toDto(entity))
                .collect(Collectors.toList());
    }

    @Override
    public PerfilDto atualizar(PerfilDto perfilDto) {
        return perfilRepository.findById(perfilDto.id())
                .map(entity -> {
                    entity.setNivel(perfilDto.nivel());
                    entity.setNome(perfilDto.nome());
                    return perfilMapper.toDto(perfilRepository.save(entity));

                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Perfil não encontrado!"));
    }

    @Override
    public void excluir(Long id) {
        Optional<Perfil> perfil = perfilRepository.findById(id);

        if (perfil.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Perfil não encontrado!");
        }

        perfilRepository.deleteById(id);
    }
}
