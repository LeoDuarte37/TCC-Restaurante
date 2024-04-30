package com.restaurante.grupo07.service;

import com.restaurante.grupo07.dto.PedidoDto;

import java.util.List;

public interface PedidoService {
    PedidoDto adicionar(PedidoDto pedidoDto);
    PedidoDto buscarPorId(Long id);
    List<PedidoDto> listar();
    List<Object[]> listarPorMesa(Long mesa);
    List<PedidoDto> listarPorStatus(String status);
    PedidoDto atualizar(PedidoDto pedidoDto);
    PedidoDto atualizarStatus(Long id, String status);
    void excluir(Long id);
}
