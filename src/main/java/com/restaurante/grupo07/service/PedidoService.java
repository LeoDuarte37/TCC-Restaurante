package com.restaurante.grupo07.service;

import com.restaurante.grupo07.model.Item;
import com.restaurante.grupo07.model.Pedido;
import com.restaurante.grupo07.resource.dto.PedidoDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PedidoService {
    ResponseEntity<Pedido> adicionarPedido(PedidoDto pedidoDto);
    ResponseEntity<Pedido> buscarPedidoPorId(Long id);
    ResponseEntity<List<Pedido>> listarPedidos();
    ResponseEntity<List<Object[]>> listarPedidosPorMesa(Long mesa);
    ResponseEntity<List<Pedido>> listarPedidosPorStatus(String status);
    ResponseEntity<Pedido> atualizarPedido(Long id, PedidoDto pedidoDto);
    ResponseEntity<Pedido> atualizarStatusPedido(Long id, String status);
    void excluirPedido(Long id);
}
