package com.restaurante.grupo07.service.impl;

import com.restaurante.grupo07.dto.PedidoDto;
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

import java.util.List;
import java.util.Optional;
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
    public PedidoDto adicionar(PedidoDto pedidoDto) {
        return mesaRepository.findById(pedidoDto.mesa().getId())
                .map(entity -> {
                    if (entity.getStatus() == StatusMesa.ABERTA) {
                        return pedidoMapper.toDto(pedidoRepository.save(pedidoMapper.toEntity(pedidoDto)));

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
    public List<PedidoDto> listar() {
        return pedidoRepository.findAll()
                .stream()
                .map(entity -> pedidoMapper.toDto(entity))
                .collect(Collectors.toList());
    }

    @Override
    public List<PedidoDto> listarPorMesa(Long mesa) {
        return pedidoRepository.findAllByMesa(mesa)
                .stream()
                .map(entity -> pedidoMapper.toDto(entity))
                .collect(Collectors.toList());
    }

    @Override
    public List<PedidoDto> listarPorStatus(String status) {
        return pedidoRepository.findAllByStatusOrderByDataDesc(StatusPedido.doStatus(status))
                .stream()
                .map(entity -> pedidoMapper.toDto(entity))
                .collect(Collectors.toList());
    }

    @Override
    public PedidoDto atualizar(PedidoDto pedidoDto) {
        return pedidoRepository.findById(pedidoDto.id())
                .map(entity -> {
                    entity.setMesa(pedidoDto.mesa());
                    entity.setItem(pedidoDto.item());
                    return pedidoMapper.toDto(pedidoRepository.save(entity));

                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pedido não encontrado!"));
    }

    @Override
    public PedidoDto atualizarStatus(PedidoDto pedidoDto) {
        return pedidoRepository.findById(pedidoDto.id())
                .map(entity -> {
                    entity.setStatus(StatusPedido.doStatus(pedidoDto.status()));
                    return pedidoMapper.toDto(pedidoRepository.save(entity));

                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pedido não encontrado!"));
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
