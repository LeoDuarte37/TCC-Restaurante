package com.restaurante.grupo07.service;

import com.restaurante.grupo07.dto.FecharContaDto;
import com.restaurante.grupo07.dto.ListarPorStatusDto;
import com.restaurante.grupo07.dto.ListarPedidosPorMesaDto;
import com.restaurante.grupo07.dto.PedidoDto;

import java.util.List;
import java.util.Set;

public interface PedidoService {
    PedidoDto adicionar(PedidoDto pedidoDto);
    PedidoDto buscarPorId(Long id);
    List<PedidoDto> listar();
    List<PedidoDto> listarPorMesaInStatus(ListarPedidosPorMesaDto listarPedidosPorMesaDto);
    List<PedidoDto> listarPorStatus(ListarPorStatusDto listarPorStatusDto);
    List<PedidoDto> listarPorRestaurante(Long restauranteId);
    List<PedidoDto> listarPorRestauranteDataAtual(Long restauranteId);
    void fecharConta(FecharContaDto fecharContaDto);
    PedidoDto atualizar(PedidoDto pedidoDto);
    PedidoDto atualizarStatus(PedidoDto pedidoDto);
    void excluir(Long id);
}
