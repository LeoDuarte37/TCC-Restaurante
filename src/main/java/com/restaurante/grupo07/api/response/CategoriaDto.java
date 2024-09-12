package com.restaurante.grupo07.api.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.restaurante.grupo07.infrastructure.model.Subcategoria;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record CategoriaDto (
        Long id,

        @NotBlank
        String nome,

        @NotNull
        boolean disponivel,

        @JsonIgnoreProperties("categoria")
        List<Subcategoria> subcategoria
    ){
}
