package com.restaurante.grupo07.dto.mapper;

import com.restaurante.grupo07.dto.login.AddLoginDto;
import com.restaurante.grupo07.model.Login;
import org.springframework.stereotype.Component;

@Component
public class LoginMapper {

    public AddLoginDto toDto(Login login) {
        return new AddLoginDto(
                login.getUsername(),
                login.getSenha(),
                login.getUsuario(),
                login.getPerfil()
        );
    }

    public Login toEntity(AddLoginDto addLoginDto) {
        return Login.builder()
                .username(addLoginDto.username())
                .senha(addLoginDto.senha())
                .usuario(addLoginDto.usuario())
                .perfil(addLoginDto.perfil())
                .build();
    }
}
