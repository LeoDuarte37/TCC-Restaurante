package com.restaurante.grupo07.service;

import java.util.List;

import com.restaurante.grupo07.dto.PerfilDto;

public interface PerfilService {
    PerfilDto adicionar(PerfilDto perfilDto);
    PerfilDto buscarPorId(Long id);
    List<PerfilDto> listar();
    PerfilDto atualizar(PerfilDto perfilDto);
    void excluir(Long id);
}
