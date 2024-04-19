package com.restaurante.grupo07.service;

import com.restaurante.grupo07.model.Mesa;
import com.restaurante.grupo07.model.Pedido;
import com.restaurante.grupo07.resource.dto.MesaDto;

import java.util.List;

public interface MesaService {

    Mesa buscarMesaPorId(Long id);
    List<Mesa> listarMesas();
    List<Mesa> listarMesasPorStatus(String status);
    List<Mesa> listarChamandoGarcom();
    Mesa adicionarMesa(MesaDto mesaDto);
    void excluirMesa(Long id);
    Mesa atualizarTotalMesa(Long id, float total);
    Mesa atualizarStatusMesa(Long id, String status);
}
