package com.restaurante.grupo07.service;

import com.restaurante.grupo07.model.Categoria;
import com.restaurante.grupo07.resource.dto.CategoriaDto;

import java.util.List;

public interface CategoriaService {
    Categoria buscarCategoriaPorId(Long id);
    Categoria adicionarCategoria(CategoriaDto categoriaDto);
    List<Categoria> listarCategorias();
    List<Categoria> listarCategoriasDisponiveis();
    List<Categoria> listarCategoriasPorNome(String nome);
    Categoria editarCategoria(Long id, CategoriaDto categoriaDto);
    Categoria editarStatusCategoria(Long id, boolean disponivel);
    void excluirCategoria(Long id);
}