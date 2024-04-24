package com.restaurante.grupo07.service;

import com.restaurante.grupo07.model.Categoria;
import com.restaurante.grupo07.resource.dto.CategoriaDto;

import java.util.List;

public interface CategoriaService {
    Categoria adicionarCategoria(CategoriaDto categoriaDto);
    Categoria buscarCategoriaPorId(Long id);
    List<Categoria> listarCategorias();
    List<Categoria> listarCategoriasDisponiveis();
    List<Categoria> listarCategoriasPorNome(String nome);
    Categoria editarCategoria(Long id, CategoriaDto categoriaDto);
    Categoria editarStatusCategoria(Long id, boolean disponivel);
    void excluirCategoria(Long id);
}