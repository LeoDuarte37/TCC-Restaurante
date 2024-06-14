package com.restaurante.grupo07.dto.mesa;

import jakarta.validation.constraints.NotNull;

public record AtualizarMesaDto(
        @NotNull
        Long id,

        @NotNull
        Long numero
    ) {
}
