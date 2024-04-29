package com.restaurante.grupo07.dto;


import com.restaurante.grupo07.model.Produto;

import java.util.List;

public record CategoriaDto (
        Long id,
        String nome,
        String foto,
        boolean disponivel,
        List<Produto> produto
    ){
}
