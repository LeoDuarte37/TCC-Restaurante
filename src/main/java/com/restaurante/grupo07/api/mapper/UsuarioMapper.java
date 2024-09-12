package com.restaurante.grupo07.api.mapper;

import com.restaurante.grupo07.api.request.UsuarioDto;
import com.restaurante.grupo07.infrastructure.model.Usuario;
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
