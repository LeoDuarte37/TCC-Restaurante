package com.restaurante.grupo07.service.impl;

import com.restaurante.grupo07.dto.LogarDto;
import com.restaurante.grupo07.dto.LoginDto;
import com.restaurante.grupo07.dto.SessaoDto;
import com.restaurante.grupo07.dto.UsuarioDto;
import com.restaurante.grupo07.dto.mapper.LoginMapper;
import com.restaurante.grupo07.dto.mapper.UsuarioMapper;
import com.restaurante.grupo07.repository.LoginRepository;
import com.restaurante.grupo07.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService {

    @Autowired
    private final LoginRepository loginRepository;

    @Autowired
    private final LoginMapper loginMapper;

    @Autowired
    private final UsuarioMapper usuarioMapper;

    @Override
    public SessaoDto logar(LogarDto logarDto) {
        return null;
    }

    @Override
    public UsuarioDto adicionar(LoginDto loginDto) {
        if (loginRepository.existsByUsername(loginDto.username())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        return loginMapper.toUsuarioDto(loginRepository.save(loginMapper.toEntity(loginDto)));
    }
}
