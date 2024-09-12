package com.restaurante.grupo07.api.request;

import com.restaurante.grupo07.infrastructure.model.Restaurante;
import jakarta.validation.constraints.NotNull;

public record AddMesaDto(

        @NotNull
        Long numero,

        @NotNull
        Restaurante restaurante

    ) {
}
