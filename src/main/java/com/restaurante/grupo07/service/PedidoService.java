package com.restaurante.grupo07.service;

import com.restaurante.grupo07.dto.ListarMesaPorStatusDto;
import com.restaurante.grupo07.dto.PedidoDto;

import java.util.List;

public interface PedidoService {
    PedidoDto adicionar(PedidoDto pedidoDto);
    PedidoDto buscarPorId(Long id);
    List<PedidoDto> listar();
    List<PedidoDto> listarPorMesa(Long mesa);
    List<PedidoDto> listarPorStatus(ListarMesaPorStatusDto listarMesaPorStatusDto);
    PedidoDto atualizar(PedidoDto pedidoDto);
    PedidoDto atualizarStatus(PedidoDto pedidoDto);
    void excluir(Long id);
}
