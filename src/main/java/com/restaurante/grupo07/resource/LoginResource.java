package com.restaurante.grupo07.resource;

import com.restaurante.grupo07.dto.LogarDto;
import com.restaurante.grupo07.dto.LoginDto;
import com.restaurante.grupo07.dto.SessaoDto;
import com.restaurante.grupo07.dto.UsuarioDto;
import com.restaurante.grupo07.service.LoginService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
@RequiredArgsConstructor
public class LoginResource {

    @Autowired
    private final LoginService loginService;

    @PostMapping
    public SessaoDto logar(@Valid @RequestBody LogarDto logarDto) {
        return loginService.logar(logarDto);
    }

    @PostMapping("/registrar")
    public UsuarioDto adicionar(LoginDto loginDto) {
        return loginService.adicionar(loginDto);
    }
}
