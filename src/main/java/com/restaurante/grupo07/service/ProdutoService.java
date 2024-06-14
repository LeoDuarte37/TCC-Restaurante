package com.restaurante.grupo07.service;

import com.restaurante.grupo07.dto.produto.AddProdutoDto;
import com.restaurante.grupo07.dto.produto.ProdutoDto;

import java.util.List;

public interface ProdutoService {
    ProdutoDto adicionar(AddProdutoDto addProdutoDto);

    ProdutoDto buscarPorId(Long id);

    List<ProdutoDto> listarPorNome(String nome);

    ProdutoDto atualizar(ProdutoDto ProdutoDto);

    void excluir(Long id);
}
