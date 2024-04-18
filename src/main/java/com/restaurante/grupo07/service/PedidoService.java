package com.restaurante.grupo07.service;

import com.restaurante.grupo07.model.Item;
import com.restaurante.grupo07.model.Pedido;
import com.restaurante.grupo07.resource.dto.ItemDto;
import com.restaurante.grupo07.resource.dto.PedidoDto;

import java.util.List;

public interface PedidoService {
    List<Item> listarPedidos();
    List<Item> listarPedidosPorStatus(String status);
    Pedido adicionarPedido(PedidoDto pedidoDto);
    void excluirPedido(Long id);
    Pedido atualizarPedido(Long id);
    Pedido atualizarStatusPedido(Long id, String status);

}
