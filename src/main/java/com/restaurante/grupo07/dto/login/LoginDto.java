package com.restaurante.grupo07.dto.login;

public record LoginDto(
        String username,

        String perfil,

        Long restauranteId,

        String token
    ) {
}
