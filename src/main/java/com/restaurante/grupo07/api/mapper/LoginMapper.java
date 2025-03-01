package com.restaurante.grupo07.api.mapper;

import com.restaurante.grupo07.api.request.AddLoginDto;
import com.restaurante.grupo07.infrastructure.model.Login;
import com.restaurante.grupo07.infrastructure.model.enumeration.Perfil;
import org.springframework.stereotype.Component;

@Component
public class LoginMapper {

    public AddLoginDto toDto(Login login) {
        return new AddLoginDto(
                login.getUsername(),
                login.getSenha(),
                login.getUsuario(),
                login.getPerfil().getNivel()
        );
    }

    public Login toEntity(AddLoginDto addLoginDto) {
        return Login.builder()
                .username(addLoginDto.username())
                .senha(addLoginDto.senha())
                .usuario(addLoginDto.usuario())
                .perfil(Perfil.doNivel(addLoginDto.perfil()))
                .build();
    }
}
