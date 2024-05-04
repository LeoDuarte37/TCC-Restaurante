package com.restaurante.grupo07.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.restaurante.grupo07.model.Item;
import com.restaurante.grupo07.model.Mesa;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.List;


public record PedidoDto (
        Long id,

        @NotNull
        Mesa mesa,

        @NotNull
        @JsonIgnoreProperties("pedido")
        List<Item> item,

        LocalDateTime data,

        String status
    ) {
}
