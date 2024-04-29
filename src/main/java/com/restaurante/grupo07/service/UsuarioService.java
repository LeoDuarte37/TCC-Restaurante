package com.restaurante.grupo07.service;

import java.util.List;

import com.restaurante.grupo07.model.Usuario;
import com.restaurante.grupo07.dto.UsuarioDto;
import org.springframework.http.ResponseEntity;

public interface UsuarioService {
    ResponseEntity<Usuario> adicionar(UsuarioDto usuarioDto);
    ResponseEntity<Usuario> buscarPorId(Long id);
    ResponseEntity<List<Usuario>> listar();
    ResponseEntity<Usuario> atualizar(UsuarioDto usuarioDto);
    void excluir(Long id);
}
