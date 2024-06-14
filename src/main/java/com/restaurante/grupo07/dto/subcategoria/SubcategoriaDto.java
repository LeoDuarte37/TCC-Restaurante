package com.restaurante.grupo07.dto.subcategoria;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.restaurante.grupo07.model.Categoria;
import com.restaurante.grupo07.model.Produto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record SubcategoriaDto(
        Long id,

        String nome,

        boolean disponivel,

        @JsonIgnoreProperties("subcategoria")
        List<Produto> produto,

        @JsonIgnoreProperties("subcategoria")
        Categoria categoria
    ) {
}
