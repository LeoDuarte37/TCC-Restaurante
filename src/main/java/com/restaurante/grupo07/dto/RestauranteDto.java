package com.restaurante.grupo07.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.restaurante.grupo07.model.Contato;
import com.restaurante.grupo07.model.Endereco;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RestauranteDto (
        Long id,
        @NotNull @NotBlank String nome,
        @JsonIgnore @NotNull @NotBlank String cnpj,
        @NotNull Endereco endereco,
        @NotNull Contato contato
    ) {

//    public RestauranteDto(Long id, String nome, Endereco endereco, Contato contato) {
//        this(id, nome, 0, endereco, contato);
//    }
}
