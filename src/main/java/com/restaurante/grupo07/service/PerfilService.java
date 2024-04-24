package com.restaurante.grupo07.service;

import java.util.List;

import com.restaurante.grupo07.model.Perfil;
import com.restaurante.grupo07.resource.dto.PerfilDto;

public interface PerfilService {
    Perfil adicionarPerfil(PerfilDto perfilDto);
    Perfil buscarPerfilPorId(Long id);
    List<Perfil> listarPerfis();
    Perfil atualizarPerfil(Long id, PerfilDto perfilDto);
    void excluirPerfil(Long id);
}
