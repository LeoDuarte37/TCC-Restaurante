package com.restaurante.grupo07.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record EnderecoDto (
        Long id,
        @NotNull @NotBlank String rua,
        @NotNull @NotBlank String bairro,
        @NotNull @NotBlank String cidade,
        @NotNull @NotBlank String uf
    ) {
}
