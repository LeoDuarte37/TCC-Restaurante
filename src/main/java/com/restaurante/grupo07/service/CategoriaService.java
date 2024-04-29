package com.restaurante.grupo07.service;

import com.restaurante.grupo07.dto.CategoriaDto;

import java.util.List;

public interface CategoriaService {
    CategoriaDto adicionar(com.restaurante.grupo07.dto.CategoriaDto categoriaDto);
    CategoriaDto buscarPorId(Long id);
    List<CategoriaDto> buscarPorNome(String nome);
    List<CategoriaDto> listar();
    List<CategoriaDto> listarDisponiveis();
    CategoriaDto atualizar(com.restaurante.grupo07.dto.CategoriaDto categoriaDto);
    CategoriaDto atualizarStatus(Long id, boolean disponivel);
    void excluir(Long id);
}