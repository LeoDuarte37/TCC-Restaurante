package com.restaurante.grupo07.dto;


import com.restaurante.grupo07.model.Produto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record CategoriaDto (
        Long id,
        @NotNull @NotBlank String nome,
        @NotNull @NotBlank String foto,
        @NotNull boolean disponivel,
        List<Produto> produto
    ){
}
