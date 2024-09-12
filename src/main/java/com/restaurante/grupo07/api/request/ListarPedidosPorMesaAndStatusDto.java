package com.restaurante.grupo07.api.request;

import jakarta.validation.constraints.NotNull;

import java.util.List;

public record ListarPedidosPorMesaAndStatusDto(
        @NotNull
        Long mesa,

        @NotNull
        List<String> statusPedidos

    ) {
}
