package com.restaurante.grupo07.service;

import com.restaurante.grupo07.dto.usuario.UsuarioDto;

import java.util.List;

public interface UsuarioService {
    UsuarioDto buscarPorId(Long id);

    List<UsuarioDto> listar();
}
