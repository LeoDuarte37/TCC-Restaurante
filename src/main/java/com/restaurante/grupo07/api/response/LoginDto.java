package com.restaurante.grupo07.api.response;

public record LoginDto(
        String username,

        String perfil,

        Long restauranteId,

        String restauranteUuid,

        String token
    ) {
}
