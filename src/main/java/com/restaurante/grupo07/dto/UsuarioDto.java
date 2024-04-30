package com.restaurante.grupo07.dto;


import com.restaurante.grupo07.model.Contato;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UsuarioDto (
        Long id,
        @NotNull @NotBlank String nome,
        @NotNull Contato contato
    ) {
}
