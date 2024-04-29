package com.restaurante.grupo07.service.impl;

import com.restaurante.grupo07.model.Perfil;
import com.restaurante.grupo07.repository.PerfilRepository;
import com.restaurante.grupo07.dto.PerfilDto;
import com.restaurante.grupo07.service.PerfilService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PerfilServiceImpl implements PerfilService {

    @Autowired
    private final PerfilRepository perfilRepository;
    @Override
    public ResponseEntity<Perfil> adicionar(PerfilDto perfilDto) {
        return null;
    }

    @Override
    public ResponseEntity<Perfil> buscarPorId(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<List<Perfil>> listar() {
        return null;
    }

    @Override
    public ResponseEntity<Perfil> atualizar(PerfilDto perfilDto) {
        return null;
    }

    @Override
    public void excluir(Long id) {

    }
}
