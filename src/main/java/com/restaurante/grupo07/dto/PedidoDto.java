package com.restaurante.grupo07.dto;

import com.restaurante.grupo07.model.Item;
import com.restaurante.grupo07.model.Mesa;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.List;


public record PedidoDto (
        Long id,
        @NotNull Mesa mesa,
        @NotNull List<Item> item,
        @NotNull float total,
        LocalDateTime data,
        String status
    ) {

    //    public PedidoDto(Long id, Long idMesa, List<Item> item, float valor, String status) {
    //        this(id, idMesa, item, valor, null, status);
    //    }
}
