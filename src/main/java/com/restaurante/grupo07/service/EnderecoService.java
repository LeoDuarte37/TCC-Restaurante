package com.restaurante.grupo07.service;

import java.util.List;

import com.restaurante.grupo07.model.Endereco;
import com.restaurante.grupo07.resource.dto.EnderecoDto;
import org.springframework.http.ResponseEntity;

public interface EnderecoService {
    ResponseEntity<Endereco> adicionarEndereco(EnderecoDto enderecoDto);
    ResponseEntity<Endereco> buscarEnderecoPorId(Long id);
    ResponseEntity<List<Endereco>> listarEnderecos();
    ResponseEntity<Endereco> atualizarEndereco(Long id, EnderecoDto enderecoDto);
    void excluirPedido(Long id);
}