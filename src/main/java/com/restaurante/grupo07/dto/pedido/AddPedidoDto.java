package com.restaurante.grupo07.dto.pedido;

import com.restaurante.grupo07.model.Item;
import com.restaurante.grupo07.model.Mesa;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record AddPedidoDto(
        @NotNull
        Mesa mesa,

        @NotNull
        List<Item> item
    ) {
}
