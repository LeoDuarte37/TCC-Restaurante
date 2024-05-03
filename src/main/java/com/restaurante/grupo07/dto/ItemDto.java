package com.restaurante.grupo07.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.restaurante.grupo07.model.Pedido;
import com.restaurante.grupo07.model.Produto;
import jakarta.validation.constraints.NotNull;

public record ItemDto(
        Long id,
        @NotNull Produto produto,
        @NotNull int quantidade,
        String observacao,
        @NotNull @JsonIgnoreProperties("item") Pedido pedido
    ) {
}
