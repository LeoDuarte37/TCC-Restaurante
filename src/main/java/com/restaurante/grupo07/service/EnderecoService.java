package com.restaurante.grupo07.service;

import java.util.List;

import com.restaurante.grupo07.model.Endereco;
import com.restaurante.grupo07.resource.dto.EnderecoDto;

public interface EnderecoService {
    Endereco adicionarEndereco(EnderecoDto enderecoDto);
    Endereco buscarEnderecoPorId(Long id);
    List<Endereco> listarEnderecos();
    Endereco atualizarEndereco(Long id, EnderecoDto enderecoDto);
    void excluirPedido(Long id);
}