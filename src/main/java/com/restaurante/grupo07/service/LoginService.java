package com.restaurante.grupo07.service;

import com.restaurante.grupo07.dto.LogarDto;
import com.restaurante.grupo07.dto.LoginDto;
import com.restaurante.grupo07.dto.SessaoDto;

import java.util.Optional;

public interface LoginService {

    Optional<SessaoDto> autenticar(Optional<LogarDto> logarDto);
    Optional<LoginDto> cadastrar(LoginDto loginDto);
    Optional<LoginDto> atualizar(LoginDto loginDto);
    void excluir(String username);
}

