package com.restaurante.grupo07.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;

public record PerfilDto (
        Long id,
        int nivel,
        @JsonIgnore String nome
    ) {

    public PerfilDto(Long id, int nivel) {
        this(id, nivel, null);
    }
}
