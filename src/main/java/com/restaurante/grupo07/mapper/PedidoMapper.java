package com.restaurante.grupo07.mapper;

import com.restaurante.grupo07.dto.pedido.AddPedidoDto;
import com.restaurante.grupo07.dto.pedido.PedidoDto;
import com.restaurante.grupo07.enumeration.StatusMesa;
import com.restaurante.grupo07.enumeration.StatusPedido;
import com.restaurante.grupo07.model.Item;
import com.restaurante.grupo07.model.Pedido;
import com.restaurante.grupo07.model.Produto;
import com.restaurante.grupo07.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

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
