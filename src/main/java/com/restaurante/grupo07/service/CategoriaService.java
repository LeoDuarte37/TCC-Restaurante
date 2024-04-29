package com.restaurante.grupo07.service;

import com.restaurante.grupo07.model.Categoria;
import com.restaurante.grupo07.dto.CategoriaDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CategoriaService {
    ResponseEntity<Categoria> adicionar(CategoriaDto categoriaDto);
    ResponseEntity<Categoria> buscarPorId(Long id);
    ResponseEntity<List<Categoria>> buscarPorNome(String nome);
    ResponseEntity<List<Categoria>> listar();
    ResponseEntity<List<Categoria>> listarDisponiveis();
    ResponseEntity<Categoria> atualizar(CategoriaDto categoriaDto);
    ResponseEntity<Categoria> atualizarStatus(Long id, boolean disponivel);
    void excluir(Long id);
}