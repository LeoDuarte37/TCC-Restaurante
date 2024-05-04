package com.restaurante.grupo07.dto.mapper;

import com.restaurante.grupo07.dto.MesaDto;
import com.restaurante.grupo07.enumeration.StatusMesa;
import com.restaurante.grupo07.model.Mesa;
import org.springframework.stereotype.Component;

@Component
public class MesaMapper {

    public MesaDto toDto(Mesa mesa) {
        return new MesaDto(
                mesa.getId(),
                mesa.getNumero(),
                mesa.getRestaurante(),
                mesa.isChamarGarcom(),
                String.valueOf(mesa.getStatus())
        );
    }

    public Mesa toEntity(MesaDto mesaDto) {
        return Mesa.builder()
                .numero(mesaDto.numero())
                .restaurante(mesaDto.restaurante())
                .status(StatusMesa.doStatus("D"))
                .build();
    }
}
