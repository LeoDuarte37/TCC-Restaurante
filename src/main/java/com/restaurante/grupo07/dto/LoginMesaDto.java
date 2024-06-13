package com.restaurante.grupo07.dto;

import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record LoginMesaDto(
        @NotNull
        String uuid,

        @NotNull
        Long numero
    ) {
}
