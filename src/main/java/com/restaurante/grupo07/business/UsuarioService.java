package com.restaurante.grupo07.business;

import com.restaurante.grupo07.api.request.UsuarioDto;

import java.util.List;

public interface UsuarioService {
    UsuarioDto buscarPorId(Long id);

    List<UsuarioDto> listar();
}
