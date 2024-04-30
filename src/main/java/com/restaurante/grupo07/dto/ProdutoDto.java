package com.restaurante.grupo07.dto;


import com.restaurante.grupo07.model.Categoria;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProdutoDto (
        Long id,
        @NotNull @NotBlank String nome,
        @NotNull @NotBlank String descricao,
        @NotNull @NotBlank String foto,
        @NotNull float valor,
        @NotNull boolean disponivel,
        @NotNull Categoria categoria
    ) {
}
