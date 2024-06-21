package com.restaurante.grupo07.dto.produto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AddProdutoDto(
        @NotBlank
        String nome,

        @NotBlank
        String descricao,

        @NotBlank
        String foto,

        @NotNull
        double valor,

        @NotNull
        boolean disponivel,

        @NotNull
        Long subcategoriaId
    ) {
}
