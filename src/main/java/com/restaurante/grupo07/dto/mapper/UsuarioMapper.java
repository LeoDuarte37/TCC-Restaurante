package com.restaurante.grupo07.dto.mapper;

import com.restaurante.grupo07.dto.usuario.UsuarioDto;
import com.restaurante.grupo07.model.Usuario;
import org.springframework.stereotype.Component;

@Component
public class UsuarioMapper {

    public UsuarioDto toDto(Usuario usuario) {
        return new UsuarioDto(
                usuario.getNome(),
                usuario.getContato()
        );
    }
}
