package com.restaurante.grupo07.service;

public interface MesaService {
    List<Pedido> verPedidos(Long id);
    Pedido adicionarPedido();
    Mesa atualizarStatus(Long id, String status);
}
