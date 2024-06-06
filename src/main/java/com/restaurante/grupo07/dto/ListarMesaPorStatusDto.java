package com.restaurante.grupo07.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ListarMesaPorStatusDto (

    @NotNull
    Long restauranteId,

    @NotBlank
    String status

    ) {
}