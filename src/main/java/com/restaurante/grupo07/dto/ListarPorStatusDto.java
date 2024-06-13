package com.restaurante.grupo07.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ListarPorStatusDto(

    @NotNull
    Long restauranteId,

    @NotBlank
    String status

    ) {
}