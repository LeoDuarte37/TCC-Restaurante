package com.restaurante.grupo07.service;

import java.util.List;

import com.restaurante.grupo07.model.Usuario;
import com.restaurante.grupo07.resource.dto.UsuarioDto;
import org.springframework.http.ResponseEntity;

public interface UsuarioService {
    ResponseEntity<Usuario> adicionarUsuario(UsuarioDto usuarioDto);
    ResponseEntity<Usuario> buscarUsuarioPorId(Long id);
    ResponseEntity<List<Usuario>> listarUsuarios();
    ResponseEntity<Usuario> atualizarUsuario(Long id, UsuarioDto usuarioDto);
    void excluirUsuario(Long id);
}
