package com.restaurante.grupo07.dto.mapper;

import com.restaurante.grupo07.dto.PedidoDto;
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

    public Pedido toEntity(PedidoDto pedidoDto) {
        return Pedido.builder()
                .mesa(pedidoDto.mesa())
                .item(pedidoDto.item())
                .status(StatusPedido.doStatus("R"))
                .build();
    }
}
