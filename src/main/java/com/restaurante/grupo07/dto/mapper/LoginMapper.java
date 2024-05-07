package com.restaurante.grupo07.dto.mapper;

import com.restaurante.grupo07.dto.LoginDto;
import com.restaurante.grupo07.dto.UsuarioDto;
import com.restaurante.grupo07.model.Login;
import org.springframework.stereotype.Component;

@Component
public class LoginMapper {

    public UsuarioDto toUsuarioDto(Login login) {
        return new UsuarioDto(
                login.getUsuario().getId(),
                login.getUsuario().getNome(),
                login.getUsuario().getContato(),
                login.getUsuario().getPerfil()
        );
    }

    public Login toEntity(LoginDto loginDto) {
        return Login.builder()
                .username(loginDto.username())
                .senha(loginDto.senha())
                .usuario(loginDto.usuario())
                .build();
    }
}
