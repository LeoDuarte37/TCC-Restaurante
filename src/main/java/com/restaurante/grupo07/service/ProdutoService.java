package com.restaurante.grupo07.service;

import com.restaurante.grupo07.model.Produto;
import com.restaurante.grupo07.dto.ProdutoDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProdutoService {
    ResponseEntity<Produto> adicionar(ProdutoDto produtoDto);
    ResponseEntity<Produto> buscarPorId(Long id);
    ResponseEntity<List<Produto>> listar();
    ResponseEntity<List<Produto>> listarDisponiveis();
    ResponseEntity<List<Produto>> listarPorNome(String nome);
    ResponseEntity<Produto> atualizar(ProdutoDto produtoDto);
    ResponseEntity<Produto> atualizarStatus(Long id, boolean disponivel);
    void excluir(Long id);
}
