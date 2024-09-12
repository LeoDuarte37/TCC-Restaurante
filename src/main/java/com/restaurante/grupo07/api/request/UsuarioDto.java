package com.restaurante.grupo07.api.request;

import com.restaurante.grupo07.infrastructure.model.Contato;

public record UsuarioDto (

        String nome,

        Contato contato
    ) {
}
