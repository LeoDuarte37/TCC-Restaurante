package com.restaurante.grupo07.service;

import com.restaurante.grupo07.model.Produto;
import com.restaurante.grupo07.resource.dto.ProdutoDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProdutoService {
    ResponseEntity<Produto> adicionarProduto(ProdutoDto produtoDto);
    ResponseEntity<Produto> buscarProdutoPorId(Long id);
    ResponseEntity<List<Produto>> listarProdutos();
    ResponseEntity<List<Produto>> listarProdutosDisponiveis();
    ResponseEntity<List<Produto>> listarProdutosPorNome(String nome);
    ResponseEntity<Produto> editarProduto(Long id, ProdutoDto produtoDto);
    ResponseEntity<Produto> editarStatusProduto(Long id, boolean disponivel);
    void excluirProduto(Long id);
}
