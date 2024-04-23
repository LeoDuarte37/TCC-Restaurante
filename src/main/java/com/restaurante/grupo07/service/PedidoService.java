package com.restaurante.grupo07.service;

import com.restaurante.grupo07.model.Item;
import com.restaurante.grupo07.model.Pedido;
import com.restaurante.grupo07.resource.dto.PedidoDto;

import java.util.List;

public interface PedidoService {
    Pedido buscarPedidoPorId(Long id);
    Pedido adicionarPedido(PedidoDto pedidoDto);
    List<Item> listarPedidos();
    List<Item> listarPedidosPorStatus(String status);
    Pedido atualizarPedido(Long id, Pedido pedido);
    Pedido atualizarStatusPedido(Long id, String status);
    void excluirPedido(Long id);
}
