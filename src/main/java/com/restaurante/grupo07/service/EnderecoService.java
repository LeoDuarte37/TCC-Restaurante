package com.restaurante.grupo07.service;

import java.util.List;

import com.restaurante.grupo07.model.Endereco;
import com.restaurante.grupo07.dto.EnderecoDto;
import org.springframework.http.ResponseEntity;

public interface EnderecoService {
    ResponseEntity<Endereco> adicionar(EnderecoDto enderecoDto);
    ResponseEntity<Endereco> buscarPorId(Long id);
    ResponseEntity<List<Endereco>> listar();
    ResponseEntity<Endereco> atualizar(EnderecoDto enderecoDto);
    void excluir(Long id);
}