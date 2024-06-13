package com.restaurante.grupo07.dto;

import com.restaurante.grupo07.model.Categoria;
import com.restaurante.grupo07.model.Produto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record SubcategoriaDto(
        Long id,

        @NotBlank
        String nome,

        @NotNull
        boolean disponivel,

        List<Produto> produto,

        @NotNull
        Categoria categoria
    ) {
}
