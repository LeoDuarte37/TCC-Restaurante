package com.restaurante.grupo07.api.request;

import com.restaurante.grupo07.infrastructure.model.Item;
import com.restaurante.grupo07.infrastructure.model.Mesa;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record AtualizarPedidoDto(

        @NotNull
        Long id,

        @NotNull
        Mesa mesa,

        @NotNull
        List<Item> item
    ) {
}
