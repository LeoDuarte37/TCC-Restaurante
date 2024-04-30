package com.restaurante.grupo07.service.impl;

import com.restaurante.grupo07.dto.mapper.EnderecoMapper;
import com.restaurante.grupo07.repository.EnderecoRepository;
import com.restaurante.grupo07.dto.EnderecoDto;
import com.restaurante.grupo07.service.EnderecoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EnderecoServiceImpl implements EnderecoService {

    @Autowired
    private final EnderecoRepository enderecoRepository;

    @Autowired
    private final EnderecoMapper enderecoMapper;

    @Override
    public EnderecoDto adicionar(EnderecoDto enderecoDto) {
        return null;
    }

    @Override
    public EnderecoDto buscarPorId(Long id) {
        return null;
    }

    @Override
    public List<EnderecoDto> listar() {
        return null;
    }

    @Override
    public EnderecoDto atualizar(EnderecoDto enderecoDto) {
        return null;
    }

    @Override
    public void excluir(Long id) {

    }
}
