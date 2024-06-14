package com.restaurante.grupo07.dto.mesa;

import com.restaurante.grupo07.model.Restaurante;
import jakarta.validation.constraints.NotNull;

public record AddMesaDto(

        @NotNull
        Long numero,

        @NotNull
        Restaurante restaurante

    ) {
}
