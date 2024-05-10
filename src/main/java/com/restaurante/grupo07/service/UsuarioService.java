package com.restaurante.grupo07.service;

import java.util.List;

import com.restaurante.grupo07.dto.UsuarioDto;

public interface UsuarioService {
    UsuarioDto buscarPorId(Long id);
    List<UsuarioDto> listar();
    UsuarioDto atualizar(UsuarioDto usuarioDto);
}
