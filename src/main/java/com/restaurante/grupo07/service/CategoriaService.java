package com.restaurante.grupo07.service;

import com.restaurante.grupo07.model.Categoria;
import com.restaurante.grupo07.resource.dto.CategoriaDto;

import java.util.List;

public interface CategoriaService {
    Categoria buscarCategoriaPorId(Long id);
    List<Categoria> listarCategorias();
    List<Categoria> listarCategoriasDisponiveis();
    List<Categoria> listarCategoriasPorNome(String nome);
    Categoria adicionarCategoria(CategoriaDto categoriaDto);
    Categoria editarCategoria(Long id, Categoria categoria);
    Categoria editarStatusCategoria(Long id, boolean disponivel);
    void excluirCategoria(Long id);
}
