package com.restaurante.grupo07.service;

import com.restaurante.grupo07.dto.UsuarioDto;

import java.util.List;

public interface UsuarioService {
    UsuarioDto buscarPorId(Long id);
    List<UsuarioDto> listar();
    UsuarioDto atualizar(UsuarioDto usuarioDto);
}
