package com.restaurante.grupo07.dto;


public record ItemDto (
        Long id,
        Long idProduto,
        int quantidade,
        String observacao,
        Long idPedido
    ) {
}
