package com.restaurante.grupo07.service;

import java.util.List;

import com.restaurante.grupo07.dto.EnderecoDto;

public interface EnderecoService {
    EnderecoDto adicionar(EnderecoDto enderecoDto);
    EnderecoDto buscarPorId(Long id);
    List<EnderecoDto> listar();
    EnderecoDto atualizar(EnderecoDto enderecoDto);
    void excluir(Long id);
}