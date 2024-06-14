package com.restaurante.grupo07.dto.restaurante;


import com.restaurante.grupo07.model.Contato;
import com.restaurante.grupo07.model.Endereco;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.UUID;

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
