package com.restaurante.grupo07.service.impl;

import com.restaurante.grupo07.model.Endereco;
import com.restaurante.grupo07.repository.EnderecoRepository;
import com.restaurante.grupo07.dto.EnderecoDto;
import com.restaurante.grupo07.service.EnderecoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EnderecoServiceImpl implements EnderecoService {

    @Autowired
    private final EnderecoRepository enderecoRepository;
    @Override
    public ResponseEntity<Endereco> adicionar(EnderecoDto enderecoDto) {
        return null;
    }

    @Override
    public ResponseEntity<Endereco> buscarPorId(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<List<Endereco>> listar() {
        return null;
    }

    @Override
    public ResponseEntity<Endereco> atualizar(EnderecoDto enderecoDto) {
        return null;
    }

    @Override
    public void excluir(Long id) {

    }
}
