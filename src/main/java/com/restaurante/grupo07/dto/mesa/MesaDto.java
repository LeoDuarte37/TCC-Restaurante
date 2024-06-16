package com.restaurante.grupo07.dto.mesa;

public record MesaDto(
        Long id,

        Long numero,

        Long restauranteId,

        String restauranteUuid,

        boolean chamarGarcom,

        String status
    ) {
}
