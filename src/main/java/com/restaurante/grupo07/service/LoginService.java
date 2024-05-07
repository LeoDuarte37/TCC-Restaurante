package com.restaurante.grupo07.service;

import com.restaurante.grupo07.dto.LogarDto;
import com.restaurante.grupo07.dto.LoginDto;
import com.restaurante.grupo07.dto.SessaoDto;
import com.restaurante.grupo07.dto.UsuarioDto;

public interface LoginService {

    SessaoDto logar(LogarDto logarDto);
    UsuarioDto adicionar(LoginDto loginDto);
}
