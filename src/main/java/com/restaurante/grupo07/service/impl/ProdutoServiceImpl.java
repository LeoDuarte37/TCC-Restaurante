package com.restaurante.grupo07.service.impl;

import com.restaurante.grupo07.model.Produto;
import com.restaurante.grupo07.repository.ProdutoRepository;
import com.restaurante.grupo07.dto.ProdutoDto;
import com.restaurante.grupo07.service.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProdutoServiceImpl implements ProdutoService {

    @Autowired
    private final ProdutoRepository produtoRepository;

    @Override
    public ResponseEntity<Produto> adicionar(ProdutoDto produtoDto) {
        return null;
    }

    @Override
    public ResponseEntity<Produto> buscarPorId(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<List<Produto>> listar() {
        return null;
    }

    @Override
    public ResponseEntity<List<Produto>> listarDisponiveis() {
        return null;
    }

    @Override
    public ResponseEntity<List<Produto>> listarPorNome(String nome) {
        return null;
    }

    @Override
    public ResponseEntity<Produto> atualizar(ProdutoDto produtoDto) {
        return null;
    }

    @Override
    public ResponseEntity<Produto> atualizarStatus(Long id, boolean disponivel) {
        return null;
    }

    @Override
    public void excluir(Long id) {

    }
}
