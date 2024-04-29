package com.restaurante.grupo07.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;

public record RestauranteDto (
        Long id,
        String nome,
        @JsonIgnore int cnpj,
        Long idEndereco,
        Long idContato
    ) {

    public RestauranteDto(Long id, String nome, Long idEndereco, Long idContato) {
        this(id, nome, 0, idEndereco, idContato);
    }
}
