package com.restaurante.grupo07.dto.categoria;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AddCategoriaDto(

        @NotBlank
        String nome,

        @NotNull
        boolean disponivel,

        @NotNull
        Long restauranteId
    ) {
}
