package com.restaurante.grupo07.service.impl;

import com.restaurante.grupo07.dto.StatusDto;
import com.restaurante.grupo07.dto.pedido.AddPedidoDto;
import com.restaurante.grupo07.dto.pedido.AtualizarPedidoDto;
import com.restaurante.grupo07.dto.pedido.ListarPedidosPorMesaAndStatusDto;
import com.restaurante.grupo07.dto.pedido.PedidoDto;
import com.restaurante.grupo07.dto.mapper.PedidoMapper;
import com.restaurante.grupo07.enumeration.StatusMesa;
import com.restaurante.grupo07.enumeration.StatusPedido;
import com.restaurante.grupo07.model.Pedido;
import com.restaurante.grupo07.repository.MesaRepository;
import com.restaurante.grupo07.repository.PedidoRepository;
import com.restaurante.grupo07.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class PedidoServiceImpl implements PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private PedidoMapper pedidoMapper;

    @Autowired
    private MesaRepository mesaRepository;

    @Override
    public PedidoDto adicionar(AddPedidoDto addPedidoDto) {
        return mesaRepository.findById(addPedidoDto.mesa().getId())
                .map(entity -> {
                    if (entity.getStatus() == StatusMesa.ABERTA) {
                        return pedidoMapper.toDto(pedidoRepository.save(pedidoMapper.toEntity(addPedidoDto)));

                    }

                    throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Mesa ainda não foi aberta por um cliente!");

                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Mesa não encontrada"));
    }

    @Override
    public PedidoDto buscarPorId(Long id) {
        return pedidoRepository.findById(id)
                .map(entity -> pedidoMapper.toDto(entity))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pedido não encontrado!"));
    }

    @Override
    public List<PedidoDto> listarPorMesaInStatus(ListarPedidosPorMesaAndStatusDto listarPedidosPorMesaAndStatusDto) {
        Set<StatusPedido> statusPedidos = listarPedidosPorMesaAndStatusDto.statusPedidos()
                .stream()
                .map(status -> StatusPedido.doStatus(status))
                .collect(Collectors.toSet());

        return pedidoRepository.findAllByMesaInStatus(listarPedidosPorMesaAndStatusDto.mesa(), statusPedidos)
                .stream()
                .map(entity -> pedidoMapper.toDto(entity))
                .collect(Collectors.toList());
    }

    @Override
    public List<PedidoDto> listarPorStatus(StatusDto statusDto) {
        return pedidoRepository.findAllByStatusOrderByDataDesc(statusDto.id(), StatusPedido.doStatus(statusDto.status()))
                .stream()
                .map(entity -> pedidoMapper.toDto(entity))
                .collect(Collectors.toList());
    }

    @Override
    public List<PedidoDto> listarPorRestaurante(Long restauranteId) {
        return pedidoRepository.findAllByRestaurante(restauranteId)
                .stream()
                .map(entity -> pedidoMapper.toDto(entity))
                .collect(Collectors.toList());
    }

    @Override
    public List<PedidoDto> listarPorRestauranteDataAtual(Long restauranteId) {
        return pedidoRepository.findAllByRestauranteCurrenteDate(restauranteId)
                .stream()
                .map(entity -> pedidoMapper.toDto(entity))
                .collect(Collectors.toList());
    }

    @Override
    public PedidoDto atualizar(AtualizarPedidoDto atualizarPedidoDto) {
        return pedidoRepository.findById(atualizarPedidoDto.id())
                .map(entity -> {
                    entity.setMesa(atualizarPedidoDto.mesa());
                    entity.setItem(atualizarPedidoDto.item());
                    return pedidoMapper.toDto(pedidoRepository.save(entity));

                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pedido não encontrado!"));
    }

    @Override
    public PedidoDto atualizarStatus(StatusDto statusDto) {
        return pedidoRepository.findById(statusDto.id())
                .map(entity -> {
                    entity.setStatus(StatusPedido.doStatus(statusDto.status()));
                    return pedidoMapper.toDto(pedidoRepository.save(entity));

                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pedido não encontrado!"));
    }

    @Override
    public void fecharConta(Long id) {
        List<StatusPedido> statusReference = new ArrayList<>(Arrays.asList(
                StatusPedido.REALIZADO, StatusPedido.FEITO, StatusPedido.ENTREGUE
        ));

        pedidoRepository.fecharConta(id, StatusPedido.PAGO, statusReference);
    }

    @Override
    public void excluir(Long id) {
        Optional<Pedido> pedido = pedidoRepository.findById(id);

        if (pedido.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        pedidoRepository.deleteById(id);
    }
}
