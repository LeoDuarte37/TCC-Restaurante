package com.restaurante.grupo07.service;

import com.restaurante.grupo07.dto.MesaDto;

import java.util.List;

public interface MesaService {
    MesaDto adicionar(MesaDto mesaDto);
    MesaDto buscarPorNumero(Long numero);
    List<MesaDto> listar();
    List<MesaDto> listarPorStatus(String status);
    List<MesaDto> listarChamandoGarcom();
    MesaDto atualizar(MesaDto mesaDto);
    MesaDto atualizarStatus(Long numero, String status);
    MesaDto atualizarChamarGarcom(Long numero, boolean chamarGarcom);
    void excluir(Long numero);

    // ResponseEntity<Mesa> fecharMesa(Long numero);
}
