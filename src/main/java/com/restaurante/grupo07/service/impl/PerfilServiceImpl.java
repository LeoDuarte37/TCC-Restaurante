package com.restaurante.grupo07.service.impl;

import com.restaurante.grupo07.dto.mapper.PerfilMapper;
import com.restaurante.grupo07.repository.PerfilRepository;
import com.restaurante.grupo07.dto.PerfilDto;
import com.restaurante.grupo07.service.PerfilService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PerfilServiceImpl implements PerfilService {

    @Autowired
    private final PerfilRepository perfilRepository;

    @Autowired
    private final PerfilMapper perfilMapper;

    @Override
    public PerfilDto adicionar(PerfilDto perfilDto) {
        return null;
    }

    @Override
    public PerfilDto buscarPorId(Long id) {
        return null;
    }

    @Override
    public List<PerfilDto> listar() {
        return null;
    }

    @Override
    public PerfilDto atualizar(PerfilDto perfilDto) {
        return null;
    }

    @Override
    public void excluir(Long id) {

    }
}
