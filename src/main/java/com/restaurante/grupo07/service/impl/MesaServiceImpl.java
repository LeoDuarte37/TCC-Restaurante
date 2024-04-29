package com.restaurante.grupo07.service.impl;

import com.restaurante.grupo07.model.Mesa;
import com.restaurante.grupo07.repository.MesaRepository;
import com.restaurante.grupo07.dto.MesaDto;
import com.restaurante.grupo07.service.MesaService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MesaServiceImpl implements MesaService {

    @Autowired
    private final MesaRepository mesaRepository;
    @Override
    public ResponseEntity<Mesa> adicionar(MesaDto mesaDto) {
        return null;
    }

    @Override
    public ResponseEntity<Mesa> buscarPorNumero(Long numero) {
        return null;
    }

    @Override
    public ResponseEntity<List<Mesa>> listar() {
        return null;
    }

    @Override
    public ResponseEntity<List<Mesa>> listarPorStatus(String status) {
        return null;
    }

    @Override
    public ResponseEntity<List<Mesa>> listarChamandoGarcom() {
        return null;
    }

    @Override
    public ResponseEntity<Mesa> atualizar(MesaDto mesaDto) {
        return null;
    }

    @Override
    public ResponseEntity<Mesa> atualizarStatus(Long numero, String status) {
        return null;
    }

    @Override
    public ResponseEntity<Mesa> atualizarChamarGarcom(Long numero, boolean chamarGarcom) {
        return null;
    }

    @Override
    public void excluir(Long numero) {

    }
}
