package com.restaurante.grupo07.service;

import com.restaurante.grupo07.model.Categoria;
import com.restaurante.grupo07.resource.dto.CategoriaDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CategoriaService {
    ResponseEntity<Categoria> adicionarCategoria(CategoriaDto categoriaDto);
    ResponseEntity<Categoria> buscarCategoriaPorId(Long id);
    ResponseEntity<List<Categoria>> buscarCategoriasPorNome(String nome);
    ResponseEntity<List<Categoria>> listarCategorias();
    ResponseEntity<List<Categoria>> listarCategoriasDisponiveis();
    ResponseEntity<Categoria> editarCategoria(Long id, CategoriaDto categoriaDto);
    ResponseEntity<Categoria> editarStatusCategoria(Long id, boolean disponivel);
    void excluirCategoria(Long id);
}