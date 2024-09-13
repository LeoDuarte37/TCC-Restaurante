package com.restaurante.grupo07.api.request;

import com.restaurante.grupo07.infrastructure.model.Usuario;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;

@Builder
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
        String perfil
    ) {
}
