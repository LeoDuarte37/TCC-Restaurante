package com.restaurante.grupo07.service;

public interface EnderecoService {
    Endereco buscarEnderecoPorId(Long id);
    Endereco adicionarEndereco(EnderecoDto enderecoDto);
    List<Endereco> listarEnderecos();
    List<Endereco> listarEnderecoPorStatus(String status);
    Endereco atualizarEndereco(Long id, EnderecoDto enderecoDto);
    void excluirPedido(Long id);
}
