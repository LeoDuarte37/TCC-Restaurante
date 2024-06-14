package com.restaurante.grupo07.dto.pedido;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Set;

public record ListarPedidosPorMesaAndStatusDto(
        @NotNull
        Long mesa,

        @NotNull
        @NotBlank
        Set<String> statusPedidos

    ) {
}
