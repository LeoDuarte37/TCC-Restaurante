package com.restaurante.grupo07.service;

import java.util.List;

import com.restaurante.grupo07.model.Perfil;
import com.restaurante.grupo07.dto.PerfilDto;
import org.springframework.http.ResponseEntity;

public interface PerfilService {
    ResponseEntity<Perfil> adicionar(PerfilDto perfilDto);
    ResponseEntity<Perfil> buscarPorId(Long id);
    ResponseEntity<List<Perfil>> listar();
    ResponseEntity<Perfil> atualizar(PerfilDto perfilDto);
    void excluir(Long id);
}
