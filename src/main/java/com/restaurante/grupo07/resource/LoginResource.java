package com.restaurante.grupo07.resource;

import com.restaurante.grupo07.dto.LogarDto;
import com.restaurante.grupo07.dto.LoginDto;
import com.restaurante.grupo07.dto.SessaoDto;
import com.restaurante.grupo07.service.LoginService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/login")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class LoginResource {

    @Autowired
    private LoginService loginService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Transactional
    public Optional<SessaoDto> logar(@Valid @RequestBody Optional<LogarDto> logarDto) {
        return loginService.autenticar(logarDto);
    }

    @PostMapping("/cadastrar")
    @ResponseStatus(HttpStatus.CREATED)
    @Transactional
    public Optional<LoginDto> cadastrar(@Valid @RequestBody LoginDto loginDto) {
        return loginService.cadastrar(loginDto);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    @Transactional
    public Optional<LoginDto> atualizar(@Valid @RequestBody LoginDto loginDto) {
        return loginService.atualizar(loginDto);
    }

    @DeleteMapping("/{username}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Transactional
    public void excluir(@PathVariable("username") String username) {
        loginService.excluir(username);
    }
}
