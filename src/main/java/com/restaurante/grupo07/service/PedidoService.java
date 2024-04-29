package com.restaurante.grupo07.service;

import com.restaurante.grupo07.model.Pedido;
import com.restaurante.grupo07.dto.PedidoDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PedidoService {
    ResponseEntity<Pedido> adicionar(PedidoDto pedidoDto);
    ResponseEntity<Pedido> buscarPorId(Long id);
    ResponseEntity<List<Pedido>> listar();
    ResponseEntity<List<Object[]>> listarPorMesa(Long mesa);
    ResponseEntity<List<Pedido>> listarPorStatus(String status);
    ResponseEntity<Pedido> atualizar(PedidoDto pedidoDto);
    ResponseEntity<Pedido> atualizarStatus(Long id, String status);
    void excluir(Long id);
}
