package com.restaurante.grupo07.dto.subcategoria;

import com.restaurante.grupo07.model.Categoria;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AddSubcategoriaDto(

        @NotBlank
        String nome,

        @NotNull
        boolean disponivel,

        @NotNull
        Categoria categoria
    ) {
}
