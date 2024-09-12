package com.restaurante.grupo07.api.request;

import com.restaurante.grupo07.infrastructure.model.Perfil;
import com.restaurante.grupo07.infrastructure.model.Usuario;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record AddLoginDto(

        @NotBlank
        @Size(min = 5)
        String username,

        @NotBlank
        @Size(min = 5)
        String senha,

        @NotNull
        Usuario usuario,

        @NotNull
        Perfil perfil
    ) {
}
