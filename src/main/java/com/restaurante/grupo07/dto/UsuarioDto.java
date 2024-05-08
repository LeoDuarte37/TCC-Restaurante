package com.restaurante.grupo07.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.restaurante.grupo07.model.Contato;
import com.restaurante.grupo07.model.Perfil;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record UsuarioDto (
        Long id,

        @NotBlank
        @Size(max = 70)
        String nome,

        @NotNull
        Contato contato
    ) {
}
