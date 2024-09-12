package com.restaurante.grupo07.api.mapper;

import com.restaurante.grupo07.api.request.AddPedidoDto;
import com.restaurante.grupo07.api.response.PedidoDto;
import com.restaurante.grupo07.infrastructure.model.Pedido;
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
                .build();
    }
}
