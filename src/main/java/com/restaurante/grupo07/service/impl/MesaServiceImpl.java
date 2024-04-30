package com.restaurante.grupo07.service.impl;

import com.restaurante.grupo07.dto.mapper.MesaMapper;
import com.restaurante.grupo07.repository.MesaRepository;
import com.restaurante.grupo07.dto.MesaDto;
import com.restaurante.grupo07.service.MesaService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MesaServiceImpl implements MesaService {

    @Autowired
    private final MesaRepository mesaRepository;

    @Autowired
    private final MesaMapper mesaMapper;

    @Override
    public MesaDto adicionar(MesaDto mesaDto) {
        return null;
    }

    @Override
    public MesaDto buscarPorNumero(Long numero) {
        return null;
    }

    @Override
    public List<MesaDto> listar() {
        return null;
    }

    @Override
    public List<MesaDto> listarPorStatus(String status) {
        return null;
    }

    @Override
    public List<MesaDto> listarChamandoGarcom() {
        return null;
    }

    @Override
    public MesaDto atualizar(MesaDto mesaDto) {
        return null;
    }

    @Override
    public MesaDto atualizarStatus(Long numero, String status) {
        return null;
    }

    @Override
    public MesaDto atualizarChamarGarcom(Long numero, boolean chamarGarcom) {
        return null;
    }

    @Override
    public void excluir(Long numero) {

    }
}
