package com.restaurante.grupo07.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotNull;

public record PerfilDto (
        Long id,

        @NotNull
        int nivel,

        @JsonIgnore
        String nome
    ) {
}
