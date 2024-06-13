package com.restaurante.grupo07.service;

import com.restaurante.grupo07.dto.ListarPorStatusDto;
import com.restaurante.grupo07.dto.LoginMesaDto;
import com.restaurante.grupo07.dto.MesaDto;

import java.util.List;

public interface MesaService {
    MesaDto adicionar(MesaDto mesaDto);
    MesaDto buscarPorId(Long id);
    MesaDto loginMesa(LoginMesaDto loginMesaDto);
    List<MesaDto> listar();
    List<MesaDto> listarPorRestaurante(Long restauranteId);
    List<MesaDto> listarPorRestauranteAndStatus(ListarPorStatusDto listarPorStatusDto);
    List<MesaDto> listarChamandoGarcom(Long restauranteId);
    MesaDto atualizar(MesaDto mesaDto);
    MesaDto atualizarStatus(MesaDto mesaDto);
    MesaDto atualizarChamarGarcom(MesaDto mesaDto);
    void excluir(Long id);
}
