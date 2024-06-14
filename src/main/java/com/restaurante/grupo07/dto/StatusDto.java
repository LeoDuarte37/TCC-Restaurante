package com.restaurante.grupo07.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record StatusDto(

        @NotNull
        Long id,

        @NotBlank
        String status
    ) {
}