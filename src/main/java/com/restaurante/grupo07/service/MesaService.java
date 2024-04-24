package com.restaurante.grupo07.service;

import com.restaurante.grupo07.model.Mesa;
import com.restaurante.grupo07.resource.dto.MesaDto;

import java.util.List;

public interface MesaService {
    Mesa adicionarMesa(MesaDto mesaDto);
    Mesa buscarMesaPorId(Long id);
    List<Mesa> listarMesas();
    List<Mesa> listarMesasPorStatus(String status);
    List<Mesa> listarChamandoGarcom();
    Mesa atualizarMesa(Long id, MesaDto mesaDto);
    Mesa atualizarStatusMesa(Long id, String status);
    Mesa atualizarChamarGarcom(Long id, boolean chamarGarcom);
    Mesa fecharMesa(Long id);
    void excluirMesa(Long id);
}
