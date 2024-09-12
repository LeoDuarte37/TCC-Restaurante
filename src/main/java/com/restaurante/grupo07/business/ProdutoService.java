package com.restaurante.grupo07.business;

import com.restaurante.grupo07.api.request.AddProdutoDto;
import com.restaurante.grupo07.api.response.ProdutoDto;

import java.util.List;

public interface ProdutoService {
    ProdutoDto adicionar(AddProdutoDto addProdutoDto);

    ProdutoDto buscarPorId(Long id);

    List<ProdutoDto> listarPorNome(String nome);

    ProdutoDto atualizar(ProdutoDto ProdutoDto);

    void excluir(Long id);
}
