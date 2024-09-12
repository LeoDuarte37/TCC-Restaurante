package com.restaurante.grupo07.api.mapper;

import com.restaurante.grupo07.api.request.AddMesaDto;
import com.restaurante.grupo07.api.response.MesaDto;
import com.restaurante.grupo07.infrastructure.model.enumeration.StatusMesa;
import com.restaurante.grupo07.infrastructure.model.Mesa;
import org.springframework.stereotype.Component;

@Component
public class MesaMapper {

    public MesaDto toDto(Mesa mesa) {
        return new MesaDto(
                mesa.getId(),
                mesa.getNumero(),
                mesa.getRestaurante().getId(),
                mesa.getRestaurante().getUuid().toString(),
                mesa.isChamarGarcom(),
                String.valueOf(mesa.getStatus())
        );
    }

    public Mesa toEntity(AddMesaDto addMesaDto) {
        return Mesa.builder()
                .numero(addMesaDto.numero())
                .restaurante(addMesaDto.restaurante())
                .status(StatusMesa.doStatus("D"))
                .build();
    }
}
