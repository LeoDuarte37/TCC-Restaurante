package com.restaurante.grupo07.service;

import com.restaurante.grupo07.model.Produto;
import com.restaurante.grupo07.resource.dto.ProdutoDto;

import java.util.List;

public interface ProdutoService {
    Produto adicionarProduto(ProdutoDto produtoDto);
    List<Produto> listarProdutos();
    List<Produto> listarProdutosDisponiveis();
    List<Produto> listarProdutosPorNome(String nome);



}
