package com.restaurante.grupo07.dto;



public record ProdutoDto (
        Long id,
        String nome,
        String descricao,
        String foto,
        float valor,
        boolean disponivel,
        Long idCategoria
    ) {
}
