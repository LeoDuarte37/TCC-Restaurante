package com.restaurante.grupo07.api.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AtualizarCardapioDto(
        @NotNull
        Long id,

        @NotBlank
        String nome,

        @NotNull
        boolean disponivel
    ) {
}
