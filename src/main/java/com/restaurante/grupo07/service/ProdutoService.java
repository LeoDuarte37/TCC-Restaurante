package com.restaurante.grupo07.service;

import com.restaurante.grupo07.model.Produto;
import com.restaurante.grupo07.resource.dto.ProdutoDto;

import java.util.List;

public interface ProdutoService {
    Produto buscarProdutoPorId(Long id);
    Produto adicionarProduto(ProdutoDto produtoDto);
    List<Produto> listarProdutos();
    List<Produto> listarProdutosDisponiveis();
    List<Produto> listarProdutosPorNome(String nome);
    Produto editarProduto(Long id, ProdutoDto produtoDto);
    Produto editarStatusProduto(Long id, boolean disponivel);
    void excluirProduto(Long id);
}
