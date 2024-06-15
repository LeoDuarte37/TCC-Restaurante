package com.restaurante.grupo07.dto.pedido;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.restaurante.grupo07.model.Item;
import com.restaurante.grupo07.model.Mesa;

import java.time.LocalDateTime;
import java.util.List;

public record PedidoDto (
        Long id,

        @JsonIgnoreProperties(value = {"chamarGarcom", "status", "cnpj", "endereco", "contato"})
        Mesa mesa,

        @JsonIgnoreProperties(value = {"pedido", "subcategoria"})
        List<Item> item,

        LocalDateTime data,

        String status
    ) {
}
