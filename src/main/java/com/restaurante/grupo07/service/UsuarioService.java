package com.restaurante.grupo07.service;

import java.util.List;

import com.restaurante.grupo07.model.Usuario;
import com.restaurante.grupo07.resource.dto.UsuarioDto;

public interface UsuarioService {
    Usuario adicionarUsuario(UsuarioDto usuarioDto);
    Usuario buscarUsuarioPorId(Long id);
    List<Usuario> listarUsuarios();
    Usuario atualizarUsuario(Long id, UsuarioDto usuarioDto);
    void excluirUsuario(Long id);
}
