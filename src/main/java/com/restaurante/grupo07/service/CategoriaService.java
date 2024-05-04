package com.restaurante.grupo07.service;

import com.restaurante.grupo07.dto.CategoriaDto;

import java.util.List;

public interface CategoriaService {
    CategoriaDto adicionar(CategoriaDto categoriaDto);
    CategoriaDto buscarPorId(Long id);
    List<CategoriaDto> listarPorNome(String nome);
    List<CategoriaDto> listar();
    List<CategoriaDto> listarDisponiveis();
    CategoriaDto atualizar(CategoriaDto categoriaDto);
    CategoriaDto atualizarStatus(CategoriaDto categoriaDto);
    void excluir(Long id);
}