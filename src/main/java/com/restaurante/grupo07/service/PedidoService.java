package com.restaurante.grupo07.service;

import com.restaurante.grupo07.dto.StatusDto;
import com.restaurante.grupo07.dto.pedido.AddPedidoDto;
import com.restaurante.grupo07.dto.pedido.AtualizarPedidoDto;
import com.restaurante.grupo07.dto.pedido.ListarPedidosPorMesaAndStatusDto;
import com.restaurante.grupo07.dto.pedido.PedidoDto;

import java.util.List;

public interface PedidoService {
    PedidoDto adicionar(AddPedidoDto addPedidoDto);

    PedidoDto buscarPorId(Long id);

    List<PedidoDto> listarPorMesaInStatus(ListarPedidosPorMesaAndStatusDto listarPedidosPorMesaAndStatusDto);

    List<PedidoDto> listarPorStatus(StatusDto statusDto);

    List<PedidoDto> listarPorRestaurante(Long restauranteId);

    List<PedidoDto> listarPorRestauranteDataAtual(Long restauranteId);

    PedidoDto atualizar(AtualizarPedidoDto atualizarPedidoDto);

    PedidoDto atualizarStatus(StatusDto statusDto);

    void fecharConta(Long id);

    void excluir(Long id);
}
