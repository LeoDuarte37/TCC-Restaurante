package com.restaurante.grupo07.service.impl;

import com.restaurante.grupo07.dto.mapper.PedidoMapper;
import com.restaurante.grupo07.repository.PedidoRepository;
import com.restaurante.grupo07.dto.PedidoDto;
import com.restaurante.grupo07.service.PedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PedidoServiceImpl implements PedidoService {

    @Autowired
    private final PedidoRepository pedidoRepository;

    @Autowired
    private final PedidoMapper pedidoMapper;

    @Override
    public PedidoDto adicionar(PedidoDto pedidoDto) {
        return null;
    }

    @Override
    public PedidoDto buscarPorId(Long id) {
        return null;
    }

    @Override
    public List<PedidoDto> listar() {
        return null;
    }

    @Override
    public List<Object[]> listarPorMesa(Long mesa) {
        return null;
    }

    @Override
    public List<PedidoDto> listarPorStatus(String status) {
        return null;
    }

    @Override
    public PedidoDto atualizar(PedidoDto pedidoDto) {
        return null;
    }

    @Override
    public PedidoDto atualizarStatus(Long id, String status) {
        return null;
    }

    @Override
    public void excluir(Long id) {

    }
}
