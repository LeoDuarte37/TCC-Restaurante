package com.restaurante.grupo07.api.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.restaurante.grupo07.infrastructure.model.Subcategoria;
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
        double valor,

        @NotNull
        boolean disponivel,

        @NotNull
        @JsonIgnoreProperties(value = {"categoria","produto"})
        Subcategoria subcategoria
    ) {
}
