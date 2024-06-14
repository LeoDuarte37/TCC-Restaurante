package com.restaurante.grupo07.dto.mapper;

import com.restaurante.grupo07.dto.mesa.AddMesaDto;
import com.restaurante.grupo07.dto.mesa.MesaDto;
import com.restaurante.grupo07.enumeration.StatusMesa;
import com.restaurante.grupo07.model.Mesa;
import org.springframework.stereotype.Component;

@Component
public class MesaMapper {

    public MesaDto toDto(Mesa mesa) {
        return new MesaDto(
                mesa.getId(),
                mesa.getNumero(),
                mesa.getRestaurante().getId(),
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
