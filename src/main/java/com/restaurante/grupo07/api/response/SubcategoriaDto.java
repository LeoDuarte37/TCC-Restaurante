package com.restaurante.grupo07.api.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.restaurante.grupo07.infrastructure.model.Categoria;
import com.restaurante.grupo07.infrastructure.model.Produto;

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
