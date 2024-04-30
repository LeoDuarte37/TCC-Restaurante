package com.restaurante.grupo07.service;

import com.restaurante.grupo07.dto.ContatoDto;

import java.util.List;

public interface ContatoService {
    ContatoDto adicionar(ContatoDto contatoDto);
    ContatoDto buscarPorId(Long id);
    List<ContatoDto> listar();
    ContatoDto atualizar(ContatoDto contatoDto);
    void excluir(Long id);
}
