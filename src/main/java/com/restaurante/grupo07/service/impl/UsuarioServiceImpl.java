package com.restaurante.grupo07.service.impl;

import com.restaurante.grupo07.dto.usuario.UsuarioDto;
import com.restaurante.grupo07.dto.mapper.UsuarioMapper;
import com.restaurante.grupo07.repository.UsuarioRepository;
import com.restaurante.grupo07.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioMapper usuarioMapper;

    @Override
    public UsuarioDto buscarPorId(Long id) {
        return usuarioRepository.findById(id)
                .map(entity -> usuarioMapper.toDto(entity))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado!"));
    }

    @Override
    public List<UsuarioDto> listar() {
        return usuarioRepository.findAll()
                .stream()
                .map(entity -> usuarioMapper.toDto(entity))
                .collect(Collectors.toList());
    }
}
