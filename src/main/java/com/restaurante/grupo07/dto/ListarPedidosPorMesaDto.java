package com.restaurante.grupo07.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Set;

public record ListarPedidosPorMesaDto(
    @NotNull
    Long mesa,

    @NotNull
    @NotBlank
    Set<String> statusPedidos

    ) {
}
