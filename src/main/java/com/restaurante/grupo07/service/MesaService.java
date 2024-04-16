package com.restaurante.grupo07.service;

import com.restaurante.grupo07.model.Mesa;
import com.restaurante.grupo07.model.Pedido;

import java.util.List;

public interface MesaService {

    List<Mesa> listarMesas();
    Mesa atualizarStatus(Long id, String status);
}
