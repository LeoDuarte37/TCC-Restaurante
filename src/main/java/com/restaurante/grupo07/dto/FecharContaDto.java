package com.restaurante.grupo07.dto;

import com.restaurante.grupo07.model.Mesa;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Set;

public record FecharContaDto(
        @NotNull
        Long mesaId,

        @NotBlank
        String statusUpdate,

        @NotBlank
        Set<String> statusReference

    ) {
}
