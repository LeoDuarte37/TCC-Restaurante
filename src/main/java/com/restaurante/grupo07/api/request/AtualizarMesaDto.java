package com.restaurante.grupo07.api.request;

import jakarta.validation.constraints.NotNull;

public record AtualizarMesaDto(
        @NotNull
        Long id,

        @NotNull
        Long numero
    ) {
}
