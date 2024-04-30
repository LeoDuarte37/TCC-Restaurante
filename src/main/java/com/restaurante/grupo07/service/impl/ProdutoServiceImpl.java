package com.restaurante.grupo07.service.impl;

import com.restaurante.grupo07.dto.mapper.ProdutoMapper;
import com.restaurante.grupo07.repository.ProdutoRepository;
import com.restaurante.grupo07.dto.ProdutoDto;
import com.restaurante.grupo07.service.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProdutoServiceImpl implements ProdutoService {

    @Autowired
    private final ProdutoRepository produtoRepository;

    @Autowired
    private final ProdutoMapper produtoMapper;

    @Override
    public ProdutoDto adicionar(ProdutoDto produtoDto) {
        return null;
    }

    @Override
    public ProdutoDto buscarPorId(Long id) {
        return null;
    }

    @Override
    public List<ProdutoDto> listar() {
        return null;
    }

    @Override
    public List<ProdutoDto> listarDisponiveis() {
        return null;
    }

    @Override
    public List<ProdutoDto> listarPorNome(String nome) {
        return null;
    }

    @Override
    public ProdutoDto atualizar(ProdutoDto produtoDto) {
        return null;
    }

    @Override
    public ProdutoDto atualizarStatus(Long id, boolean disponivel) {
        return null;
    }

    @Override
    public void excluir(Long id) {

    }
}
