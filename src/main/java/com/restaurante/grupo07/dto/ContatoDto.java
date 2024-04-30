package com.restaurante.grupo07.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ContatoDto (
        Long id,
        @NotNull @NotBlank String email,
        @NotNull @NotBlank String telefone
    ) {
}
