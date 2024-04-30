package com.restaurante.grupo07.dto.mapper;

import com.restaurante.grupo07.dto.PerfilDto;
import com.restaurante.grupo07.model.Perfil;
import org.springframework.stereotype.Component;

@Component
public class PerfilMapper {

    public PerfilDto toDto(Perfil perfil) {
        return new PerfilDto(
                perfil.getId(),
                perfil.getNivel(),
                perfil.getNome()
        );
    }

    public Perfil toEntity(PerfilDto perfilDto) {
        return new Perfil(
                perfilDto.nivel(),
                perfilDto.nome()
        );
    }
}
