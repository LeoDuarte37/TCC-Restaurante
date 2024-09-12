package com.restaurante.grupo07.api;

import com.restaurante.grupo07.api.request.LogarDto;
import com.restaurante.grupo07.api.request.AddLoginDto;
import com.restaurante.grupo07.api.response.LoginDto;
import com.restaurante.grupo07.business.LoginService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/login")
public class LoginResource {

    @Autowired
    private LoginService loginService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Transactional
    public Optional<LoginDto> logar(@Valid @RequestBody Optional<LogarDto> logarDto) {
        return loginService.autenticar(logarDto);
    }

    @PostMapping("/cadastrar")
    @ResponseStatus(HttpStatus.CREATED)
    @Transactional
    public Optional<AddLoginDto> cadastrar(@Valid @RequestBody AddLoginDto addLoginDto) {
        return loginService.cadastrar(addLoginDto);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    @Transactional
    public Optional<AddLoginDto> atualizar(@Valid @RequestBody AddLoginDto addLoginDto) {
        return loginService.atualizar(addLoginDto);
    }

    @DeleteMapping("/{username}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Transactional
    public void excluir(@PathVariable("username") String username) {
        loginService.excluir(username);
    }
}
