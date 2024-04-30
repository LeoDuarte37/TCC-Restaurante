package com.restaurante.grupo07.service.impl;

import com.restaurante.grupo07.dto.mapper.UsuarioMapper;
import com.restaurante.grupo07.repository.UsuarioRepository;
import com.restaurante.grupo07.dto.UsuarioDto;
import com.restaurante.grupo07.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private final UsuarioRepository usuarioRepository;

    @Autowired
    private final UsuarioMapper usuarioMapper;

    @Override
    public UsuarioDto adicionar(UsuarioDto usuarioDto) {
        return null;
    }

    @Override
    public UsuarioDto buscarPorId(Long id) {
        return null;
    }

    @Override
    public List<UsuarioDto> listar() {
        return null;
    }

    @Override
    public UsuarioDto atualizar(UsuarioDto usuarioDto) {
        return null;
    }

    @Override
    public void excluir(Long id) {

    }
}
