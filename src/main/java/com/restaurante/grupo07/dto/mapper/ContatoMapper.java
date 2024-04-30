package com.restaurante.grupo07.dto.mapper;

import com.restaurante.grupo07.dto.ContatoDto;
import com.restaurante.grupo07.model.Contato;
import org.springframework.stereotype.Component;

@Component
public class ContatoMapper {

    public ContatoDto toDto(Contato contato) {
        return new ContatoDto(
                contato.getId(),
                contato.getEmail(),
                contato.getTelefone()
        );
    }

    public Contato toEntity(ContatoDto contatoDto) {
        return new Contato(contatoDto.email(), contatoDto.telefone());
    }
}
