package com.restaurante.grupo07.service;

import com.restaurante.grupo07.model.Item;
import com.restaurante.grupo07.model.Pedido;
import com.restaurante.grupo07.resource.dto.PedidoDto;

import java.util.List;

public interface PedidoService {
    Pedido adicionarPedido(PedidoDto pedidoDto);
    Pedido buscarPedidoPorId(Long id);
    List<Pedido> listarPedidos();
    List<Pedido> listarPedidosPorStatus(String status);
    Pedido atualizarPedido(Long id, PedidoDto pedidoDto);
    Pedido atualizarStatusPedido(Long id, String status);
    void excluirPedido(Long id);
}
