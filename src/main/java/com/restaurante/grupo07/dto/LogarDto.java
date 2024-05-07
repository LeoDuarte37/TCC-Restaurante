package com.restaurante.grupo07.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record LogarDto(
        @NotBlank
        @Size(min = 5)
        String username,

        @NotBlank
        @Size(min = 5)
        String senha

    ) {
}
