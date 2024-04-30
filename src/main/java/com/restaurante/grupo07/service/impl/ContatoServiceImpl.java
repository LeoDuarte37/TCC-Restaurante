package com.restaurante.grupo07.service.impl;

import com.restaurante.grupo07.dto.ContatoDto;
import com.restaurante.grupo07.dto.mapper.ContatoMapper;
import com.restaurante.grupo07.repository.ContatoRepository;
import com.restaurante.grupo07.service.ContatoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContatoServiceImpl implements ContatoService {

    @Autowired
    private final ContatoRepository contatoRepository;

    @Autowired
    private final ContatoMapper contatoMapper;

    @Override
    public ContatoDto adicionar(ContatoDto contatoDto) {
        return null;
    }

    @Override
    public ContatoDto buscarPorId(Long id) {
        return null;
    }

    @Override
    public List<ContatoDto> listar() {
        return null;
    }

    @Override
    public ContatoDto atualizar(ContatoDto contatoDto) {
        return null;
    }

    @Override
    public void excluir(Long id) {

    }
}
