package com.restaurante.grupo07.api.response;

public record MesaDto(
        Long id,

        Long numero,

        Long restauranteId,

        String restauranteUuid,

        boolean chamarGarcom,

        String status
    ) {
}
