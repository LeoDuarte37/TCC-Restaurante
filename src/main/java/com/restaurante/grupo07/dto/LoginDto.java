package com.restaurante.grupo07.dto;

import com.restaurante.grupo07.model.Perfil;
import com.restaurante.grupo07.model.Usuario;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record LoginDto(
        Long id,

        @NotBlank
        @Size(min = 5, max = 25)
        String username,

        @NotBlank
        @Size(min = 5, max = 25)
        String senha,

        @NotNull
        Usuario usuario,

        Perfil perfil

    ) {
}
