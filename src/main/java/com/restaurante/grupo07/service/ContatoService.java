package com.restaurante.grupo07.service;

import com.restaurante.grupo07.model.Contato;
import com.restaurante.grupo07.dto.ContatoDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ContatoService {
    ResponseEntity<Contato> adicionar(ContatoDto contatoDto);
    ResponseEntity<Contato> buscarPorId(Long id);
    ResponseEntity<List<Contato>> listar();
    ResponseEntity<Contato> atualizar(ContatoDto contatoDto);
    void excluir(Long id);
}
