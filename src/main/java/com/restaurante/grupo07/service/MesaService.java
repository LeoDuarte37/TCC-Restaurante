package com.restaurante.grupo07.service;

import com.restaurante.grupo07.model.Mesa;
import com.restaurante.grupo07.resource.dto.MesaDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface MesaService {
    ResponseEntity<Mesa> adicionarMesa(MesaDto mesaDto);
    ResponseEntity<Mesa> buscarMesaPorNumero(Long numero);
    ResponseEntity<List<Mesa>> listarMesas();
    ResponseEntity<List<Mesa>> listarMesasPorStatus(String status);
    ResponseEntity<List<Mesa>> listarChamandoGarcom();
    ResponseEntity<Mesa> atualizarMesa(Long numero, MesaDto mesaDto);
    ResponseEntity<Mesa> atualizarStatusMesa(Long numero, String status);
    ResponseEntity<Mesa> atualizarChamarGarcom(Long numero, boolean chamarGarcom);
    void excluirMesa(Long numero);

    // ResponseEntity<Mesa> fecharMesa(Long numero);
}
