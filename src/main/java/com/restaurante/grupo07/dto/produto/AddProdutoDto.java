package com.restaurante.grupo07.dto.produto;

import com.restaurante.grupo07.model.Subcategoria;
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
        float valor,

        @NotNull
        boolean disponivel,

        @NotNull
        Subcategoria subcategoria
    ) {
}
