package com.restaurante.grupo07.resource;

import com.restaurante.grupo07.dto.LogarDto;
import com.restaurante.grupo07.dto.LoginDto;
import com.restaurante.grupo07.dto.SessaoDto;
import com.restaurante.grupo07.service.LoginService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Transactional
    public Optional<SessaoDto> logar(@Valid @RequestBody Optional<LogarDto> logarDto) {
        return loginService.autenticar(logarDto);
    }

    @PostMapping("/cadastrar")
    @Transactional
    public Optional<LoginDto> cadastrar(@Valid @RequestBody LoginDto loginDto) {
        return loginService.cadastrar(loginDto);
    }

    @PutMapping
    @Transactional
    public Optional<LoginDto> atualizar(@Valid @RequestBody LoginDto loginDto) {
        return loginService.atualizar(loginDto);
    }

    @DeleteMapping("/{username}")
    @Transactional
    public void excluir(@PathVariable("username") String username) {
        loginService.excluir(username);
    }
}
