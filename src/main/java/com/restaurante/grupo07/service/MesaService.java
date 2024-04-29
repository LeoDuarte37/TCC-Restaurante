package com.restaurante.grupo07.service;

import com.restaurante.grupo07.model.Mesa;
import com.restaurante.grupo07.dto.MesaDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface MesaService {
    ResponseEntity<Mesa> adicionar(MesaDto mesaDto);
    ResponseEntity<Mesa> buscarPorNumero(Long numero);
    ResponseEntity<List<Mesa>> listar();
    ResponseEntity<List<Mesa>> listarPorStatus(String status);
    ResponseEntity<List<Mesa>> listarChamandoGarcom();
    ResponseEntity<Mesa> atualizar(MesaDto mesaDto);
    ResponseEntity<Mesa> atualizarStatus(Long numero, String status);
    ResponseEntity<Mesa> atualizarChamarGarcom(Long numero, boolean chamarGarcom);
    void excluir(Long numero);

    // ResponseEntity<Mesa> fecharMesa(Long numero);
}
