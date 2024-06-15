package com.restaurante.grupo07.dto.login;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.restaurante.grupo07.model.Perfil;
import com.restaurante.grupo07.model.Usuario;
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
