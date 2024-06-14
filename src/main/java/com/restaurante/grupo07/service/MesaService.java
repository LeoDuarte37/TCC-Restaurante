package com.restaurante.grupo07.service;

import com.restaurante.grupo07.dto.StatusDto;
import com.restaurante.grupo07.dto.mesa.AddMesaDto;
import com.restaurante.grupo07.dto.mesa.AtualizarMesaDto;
import com.restaurante.grupo07.dto.mesa.LoginMesaDto;
import com.restaurante.grupo07.dto.mesa.MesaDto;

import java.util.List;

public interface MesaService {
    MesaDto adicionar(AddMesaDto addMesaDto);

    MesaDto buscarPorId(Long id);

    MesaDto loginMesa(LoginMesaDto loginMesaDto);

    List<MesaDto> listarPorRestaurante(Long restauranteId);

    List<MesaDto> listarPorRestauranteAndStatus(StatusDto statusDto);

    List<MesaDto> listarChamandoGarcom(Long restauranteId);

    MesaDto atualizar(AtualizarMesaDto atualizarMesaDto);

    MesaDto atualizarStatus(StatusDto statusDto);

    MesaDto atualizarChamarGarcom(Long id);

    void excluir(Long id);
}
