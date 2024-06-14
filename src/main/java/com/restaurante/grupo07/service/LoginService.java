package com.restaurante.grupo07.service;

import com.restaurante.grupo07.dto.login.LogarDto;
import com.restaurante.grupo07.dto.login.AddLoginDto;
import com.restaurante.grupo07.dto.login.LoginDto;

import java.util.Optional;

public interface LoginService {

    Optional<LoginDto> autenticar(Optional<LogarDto> logarDto);

    Optional<AddLoginDto> cadastrar(AddLoginDto addLoginDto);

    Optional<AddLoginDto> atualizar(AddLoginDto addLoginDto);

    void excluir(String username);
}

