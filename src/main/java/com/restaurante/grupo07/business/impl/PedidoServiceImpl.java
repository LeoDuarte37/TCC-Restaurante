package com.restaurante.grupo07.business.impl;

import com.restaurante.grupo07.api.request.StatusDto;
import com.restaurante.grupo07.api.request.AddPedidoDto;
import com.restaurante.grupo07.api.request.AtualizarPedidoDto;
import com.restaurante.grupo07.api.request.ListarPedidosPorMesaAndStatusDto;
import com.restaurante.grupo07.api.response.PedidoDto;
import com.restaurante.grupo07.api.mapper.PedidoMapper;
import com.restaurante.grupo07.infrastructure.model.enumeration.StatusMesa;
import com.restaurante.grupo07.infrastructure.model.enumeration.StatusPedido;
import com.restaurante.grupo07.infrastructure.model.Pedido;
import com.restaurante.grupo07.infrastructure.repository.MesaRepository;
import com.restaurante.grupo07.infrastructure.repository.PedidoRepository;
import com.restaurante.grupo07.business.PedidoService;
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
        List<StatusPedido> statusPedidos = new ArrayList<>(Arrays.asList(
                StatusPedido.REALIZADO, StatusPedido.FEITO, StatusPedido.ENTREGUE
        ));

        int lenght = pedidoRepository.findAllByMesaInStatus(addPedidoDto.mesa().getId(), statusPedidos).size();

        return mesaRepository.findById(addPedidoDto.mesa().getId())
                .map(entity -> {
                    if (lenght == 0 && entity.getStatus() == StatusMesa.DISPONIVEL) {
                        entity.setStatus(StatusMesa.ABERTA);
                        mesaRepository.save(entity);
                        return pedidoMapper.toDto(pedidoRepository.save(pedidoMapper.toEntity(addPedidoDto)));

                    } else {
                        return pedidoMapper.toDto(pedidoRepository.save(pedidoMapper.toEntity(addPedidoDto)));
                    }

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
        List<StatusPedido> statusPedidos = listarPedidosPorMesaAndStatusDto.statusPedidos()
                .stream()
                .map(status -> StatusPedido.doStatus(status))
                .collect(Collectors.toList());

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

        pedidoRepository.findAllByMesaInStatus(id, statusReference)
                .stream()
                .map(entity -> {
                    entity.setStatus(StatusPedido.PAGO);
                    entity.getMesa().setStatus(StatusMesa.DISPONIVEL);
                    mesaRepository.save(entity.getMesa());
                    return pedidoMapper.toDto(pedidoRepository.save(entity));
                })
                .collect(Collectors.toList());
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
