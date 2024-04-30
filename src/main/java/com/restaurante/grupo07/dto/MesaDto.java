package com.restaurante.grupo07.dto;


import com.restaurante.grupo07.model.Restaurante;
import jakarta.validation.constraints.NotNull;

public record MesaDto(
        @NotNull Long numero,
        @NotNull Restaurante restaurante,
        boolean chamarGarcom,
        String status
    ) {
}
