package com.restaurante.grupo07.dto.pedido;

import jakarta.validation.constraints.NotNull;

import java.util.List;

public record ListarPedidosPorMesaAndStatusDto(
        @NotNull
        Long mesa,

        @NotNull
        List<String> statusPedidos

    ) {
}
