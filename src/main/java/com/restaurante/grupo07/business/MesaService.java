package com.restaurante.grupo07.business;

import com.restaurante.grupo07.api.request.StatusDto;
import com.restaurante.grupo07.api.request.AddMesaDto;
import com.restaurante.grupo07.api.request.AtualizarMesaDto;
import com.restaurante.grupo07.api.request.LoginMesaDto;
import com.restaurante.grupo07.api.response.MesaDto;

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
