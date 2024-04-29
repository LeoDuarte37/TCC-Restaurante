package com.restaurante.grupo07.dto;


public record MesaDto (
        Long numero,
        boolean chamarGarcom,
        Long idRestaurante,
        String status
    ) {
}
