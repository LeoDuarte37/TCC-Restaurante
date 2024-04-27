package com.restaurante.grupo07.service;

import java.util.List;

import com.restaurante.grupo07.model.Perfil;
import com.restaurante.grupo07.resource.dto.PerfilDto;
import org.springframework.http.ResponseEntity;

public interface PerfilService {
    ResponseEntity<Perfil> adicionarPerfil(PerfilDto perfilDto);
    ResponseEntity<Perfil> buscarPerfilPorId(Long id);
    ResponseEntity<List<Perfil>> listarPerfis();
    ResponseEntity<Perfil> atualizarPerfil(Long id, PerfilDto perfilDto);
    void excluirPerfil(Long id);
}
