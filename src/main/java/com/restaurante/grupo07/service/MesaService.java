package com.restaurante.grupo07.service;

import com.restaurante.grupo07.model.Mesa;
import com.restaurante.grupo07.resource.dto.MesaDto;

import java.util.List;

public interface MesaService {
    Mesa adicionarMesa(MesaDto mesaDto);
    Mesa buscarMesaPorNumero(Long numero);
    List<Mesa> listarMesas();
    List<Mesa> listarMesasPorStatus(String status);
    List<Mesa> listarChamandoGarcom();
    Mesa atualizarMesa(Long numero, MesaDto mesaDto);
    Mesa atualizarStatusMesa(Long numero, String status);
    Mesa atualizarChamarGarcom(Long numero, boolean chamarGarcom);
    Mesa fecharMesa(Long numero);
    void excluirMesa(Long numero);
}
