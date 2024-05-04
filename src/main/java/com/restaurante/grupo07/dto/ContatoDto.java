package com.restaurante.grupo07.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ContatoDto (
        Long id,

        @NotBlank
        String email,

        @NotBlank
        String telefone
    ) {
}
