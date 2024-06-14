package com.restaurante.grupo07.dto.produto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.restaurante.grupo07.model.Subcategoria;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProdutoDto (
        @NotNull
        Long id,

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
        @JsonIgnoreProperties(value = {"categoria","produto"})
        Subcategoria subcategoria
    ) {
}
