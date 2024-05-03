package com.restaurante.grupo07.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.restaurante.grupo07.model.Contato;
import com.restaurante.grupo07.model.Endereco;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record RestauranteDto (
        Long id,
        @NotNull @NotBlank String nome,
        @NotNull @NotBlank @Size(min = 14, max = 14) @JsonIgnore String cnpj,
        @NotNull Endereco endereco,
        @NotNull Contato contato
    ) {
}
