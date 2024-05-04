package com.restaurante.grupo07.service;

import com.restaurante.grupo07.dto.ProdutoDto;

import java.util.List;

public interface ProdutoService {
    ProdutoDto adicionar(ProdutoDto produtoDto);
    ProdutoDto buscarPorId(Long id);
    List<ProdutoDto> listar();
    List<ProdutoDto> listarDisponiveis();
    List<ProdutoDto> listarPorNome(String nome);
    ProdutoDto atualizar(ProdutoDto produtoDto);
    ProdutoDto atualizarStatus(ProdutoDto produtoDto);
    void excluir(Long id);
}
