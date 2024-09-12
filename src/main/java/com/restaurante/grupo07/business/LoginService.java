package com.restaurante.grupo07.business;

import com.restaurante.grupo07.api.request.LogarDto;
import com.restaurante.grupo07.api.request.AddLoginDto;
import com.restaurante.grupo07.api.response.LoginDto;

import java.util.Optional;

public interface LoginService {

    Optional<LoginDto> autenticar(Optional<LogarDto> logarDto);

    Optional<AddLoginDto> cadastrar(AddLoginDto addLoginDto);

    Optional<AddLoginDto> atualizar(AddLoginDto addLoginDto);

    void excluir(String username);
}

