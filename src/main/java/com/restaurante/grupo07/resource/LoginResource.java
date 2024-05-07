package com.restaurante.grupo07.resource;

import com.restaurante.grupo07.dto.LogarDto;
import com.restaurante.grupo07.dto.LoginDto;
import com.restaurante.grupo07.dto.SessaoDto;
import com.restaurante.grupo07.dto.UsuarioDto;
import com.restaurante.grupo07.service.LoginService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/login")
@RequiredArgsConstructor
public class LoginResource {

    @Autowired
    private final LoginService loginService;

    @PostMapping
    @Transactional
    public Optional<SessaoDto> logar(@Valid @RequestBody Optional<LogarDto> logarDto) {
        return loginService.autenticar(logarDto);
    }

    @PostMapping("/cadastrar")
    @Transactional
    public Optional<UsuarioDto> cadastrar(@Valid @RequestBody LoginDto loginDto) {
        return loginService.cadastrar(loginDto);
    }
}
