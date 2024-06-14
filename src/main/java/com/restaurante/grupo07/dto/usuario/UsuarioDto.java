package com.restaurante.grupo07.dto.usuario;

import com.restaurante.grupo07.model.Contato;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record UsuarioDto (

        String nome,

        Contato contato
    ) {
}
