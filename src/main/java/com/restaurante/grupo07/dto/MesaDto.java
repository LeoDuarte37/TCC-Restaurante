package com.restaurante.grupo07.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.restaurante.grupo07.model.Restaurante;
import jakarta.validation.constraints.NotNull;

public record MesaDto(
        Long id,
        @NotNull Long numero,
        @NotNull
        @JsonIgnoreProperties(value = {"nome", "cnpj", "endereco", "contato"})
        Restaurante restaurante,
        boolean chamarGarcom,
        String status
    ) {
}
