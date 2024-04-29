package com.restaurante.grupo07.dto;


public record EnderecoDto (
        Long id,
        String rua,
        String bairro,
        String cidade,
        String uf
    ) {
}
