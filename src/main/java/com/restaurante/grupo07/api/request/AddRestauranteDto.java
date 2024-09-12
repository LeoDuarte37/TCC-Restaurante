package com.restaurante.grupo07.api.request;

import com.restaurante.grupo07.infrastructure.model.Contato;
import com.restaurante.grupo07.infrastructure.model.Endereco;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record AddRestauranteDto(
        @NotBlank
        @Size(max = 25)
        String nome,

        @NotBlank
        @Size(min = 14, max = 14)
        String cnpj,

        @NotNull
        Endereco endereco,

        @NotNull
        Contato contato
    ) {
}
