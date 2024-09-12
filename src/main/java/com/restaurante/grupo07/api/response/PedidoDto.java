package com.restaurante.grupo07.api.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.restaurante.grupo07.infrastructure.model.Item;
import com.restaurante.grupo07.infrastructure.model.Mesa;

import java.time.LocalDateTime;
import java.util.List;

public record PedidoDto (
        Long id,

        @JsonIgnoreProperties(value = {"chamarGarcom", "status", "cnpj", "endereco", "contato", "restaurante"})
        Mesa mesa,

        @JsonIgnoreProperties(value = {"pedido", "subcategoria"})
        List<Item> item,

        @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
        LocalDateTime data,

        String status
    ) {
}
