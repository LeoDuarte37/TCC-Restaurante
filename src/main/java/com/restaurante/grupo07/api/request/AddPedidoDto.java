package com.restaurante.grupo07.api.request;

import com.restaurante.grupo07.infrastructure.model.Item;
import com.restaurante.grupo07.infrastructure.model.Mesa;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record AddPedidoDto(
        @NotNull
        Mesa mesa,

        @NotNull
        List<Item> item
    ) {
}
