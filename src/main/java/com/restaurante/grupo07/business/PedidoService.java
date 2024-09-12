package com.restaurante.grupo07.business;

import com.restaurante.grupo07.api.request.StatusDto;
import com.restaurante.grupo07.api.request.AddPedidoDto;
import com.restaurante.grupo07.api.request.AtualizarPedidoDto;
import com.restaurante.grupo07.api.request.ListarPedidosPorMesaAndStatusDto;
import com.restaurante.grupo07.api.response.PedidoDto;

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
