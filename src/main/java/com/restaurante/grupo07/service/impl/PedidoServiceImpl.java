package com.restaurante.grupo07.service.impl;

import com.restaurante.grupo07.model.Pedido;
import com.restaurante.grupo07.repository.PedidoRepository;
import com.restaurante.grupo07.dto.PedidoDto;
import com.restaurante.grupo07.service.PedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PedidoServiceImpl implements PedidoService {

    @Autowired
    private final PedidoRepository pedidoRepository;
    @Override
    public ResponseEntity<Pedido> adicionar(PedidoDto pedidoDto) {
        return null;
    }

    @Override
    public ResponseEntity<Pedido> buscarPorId(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<List<Pedido>> listar() {
        return null;
    }

    @Override
    public ResponseEntity<List<Object[]>> listarPorMesa(Long mesa) {
        return null;
    }

    @Override
    public ResponseEntity<List<Pedido>> listarPorStatus(String status) {
        return null;
    }

    @Override
    public ResponseEntity<Pedido> atualizar(PedidoDto pedidoDto) {
        return null;
    }

    @Override
    public ResponseEntity<Pedido> atualizarStatus(Long id, String status) {
        return null;
    }

    @Override
    public void excluir(Long id) {

    }
}
