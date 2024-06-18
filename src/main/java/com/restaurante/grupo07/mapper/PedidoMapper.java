package com.restaurante.grupo07.mapper;

import com.restaurante.grupo07.dto.pedido.AddPedidoDto;
import com.restaurante.grupo07.dto.pedido.PedidoDto;
import com.restaurante.grupo07.enumeration.StatusMesa;
import com.restaurante.grupo07.enumeration.StatusPedido;
import com.restaurante.grupo07.model.Pedido;
import org.springframework.stereotype.Component;

@Component
public class PedidoMapper {

    public PedidoDto toDto(Pedido pedido) {
        return new PedidoDto(
                pedido.getId(),
                pedido.getMesa(),
                pedido.getItem(),
                pedido.getData(),
                pedido.getStatus().toString()
        );
    }

    public Pedido toEntity(AddPedidoDto addPedidoDto) {
        return Pedido.builder()
                .mesa(addPedidoDto.mesa())
                .item(addPedidoDto.item())
                .status(StatusPedido.doStatus("R"))
                .build();
    }
}
