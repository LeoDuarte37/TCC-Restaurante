package com.restaurante.grupo07.dto.pedido;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record ListarPedidosPorMesaAndStatusDto(
        @NotNull
        Long mesa,

        @NotNull
        @NotBlank
        List<String> statusPedidos

    ) {
}
