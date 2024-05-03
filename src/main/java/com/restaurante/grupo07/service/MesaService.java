package com.restaurante.grupo07.service;

import com.restaurante.grupo07.dto.MesaDto;

import java.util.List;

public interface MesaService {
    MesaDto adicionar(MesaDto mesaDto);
    MesaDto buscarPorId(Long id);
    List<MesaDto> listar();
    List<MesaDto> listarPorStatus(String status);
    List<MesaDto> listarChamandoGarcom();
    MesaDto atualizar(MesaDto mesaDto);
    MesaDto atualizarStatus(Long id, String status);
    MesaDto atualizarChamarGarcom(Long id, String chamarGarcom);
    void excluir(Long id);

    // ResponseEntity<Mesa> fecharMesa(Long numero);
}
