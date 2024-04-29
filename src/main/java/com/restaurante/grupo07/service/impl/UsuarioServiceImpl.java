package com.restaurante.grupo07.service.impl;

import com.restaurante.grupo07.model.Usuario;
import com.restaurante.grupo07.repository.UsuarioRepository;
import com.restaurante.grupo07.dto.UsuarioDto;
import com.restaurante.grupo07.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private final UsuarioRepository usuarioRepository;
    @Override
    public ResponseEntity<Usuario> adicionar(UsuarioDto usuarioDto) {
        return null;
    }

    @Override
    public ResponseEntity<Usuario> buscarPorId(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<List<Usuario>> listar() {
        return null;
    }

    @Override
    public ResponseEntity<Usuario> atualizar(UsuarioDto usuarioDto) {
        return null;
    }

    @Override
    public void excluir(Long id) {

    }
}
