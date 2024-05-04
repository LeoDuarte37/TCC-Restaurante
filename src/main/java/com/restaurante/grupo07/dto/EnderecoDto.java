package com.restaurante.grupo07.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record EnderecoDto (
        Long id,

        @NotBlank
        String rua,

        @NotBlank
        String bairro,

        @NotBlank
        String cidade,

        @NotBlank
        String uf
    ) {
}
