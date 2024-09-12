package com.restaurante.grupo07.api.response;


import com.restaurante.grupo07.infrastructure.model.Contato;
import com.restaurante.grupo07.infrastructure.model.Endereco;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RestauranteDto (
        @NotNull
        Long id,

        @NotBlank
        String nome,

        @NotBlank
        String cnpj,

        @NotNull
        Endereco endereco,

        @NotNull
        Contato contato
    ) {
}
