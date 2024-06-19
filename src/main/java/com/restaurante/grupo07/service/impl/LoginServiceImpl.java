package com.restaurante.grupo07.service.impl;

import com.restaurante.grupo07.dto.login.LogarDto;
import com.restaurante.grupo07.dto.login.AddLoginDto;
import com.restaurante.grupo07.dto.login.LoginDto;
import com.restaurante.grupo07.mapper.LoginMapper;
import com.restaurante.grupo07.model.Login;
import com.restaurante.grupo07.repository.LoginRepository;
import com.restaurante.grupo07.security.JwtService;
import com.restaurante.grupo07.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Objects;
import java.util.Optional;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginRepository loginRepository;

    @Autowired
    private LoginMapper loginMapper;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Optional<LoginDto> autenticar(Optional<LogarDto> logarDto) {
        var credenciais = new UsernamePasswordAuthenticationToken(
                logarDto.get().username(),
                logarDto.get().senha()
        );

        Authentication authentication = authenticationManager.authenticate(credenciais);

        if (authentication.isAuthenticated()) {
            Optional<Login> login = loginRepository.findById(logarDto.get().username());

            if(login.isPresent()) {
                return Optional.of(
                        new LoginDto(
                            login.get().getUsername(),
                            login.get().getPerfil().getNome(),
                            login.get().getUsuario().getRestaurante().getId(),
                            login.get().getUsuario().getRestaurante().getUuid().toString(),
                            jwtService.gerarToken(login.get())
                        )
                );
            }
        }

        return Optional.empty();
    }

    @Override
    public Optional<AddLoginDto> cadastrar(AddLoginDto addLoginDto) {
        if (loginRepository.existsByUsername(addLoginDto.username())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Usuário já existente!");
        }

        Login login = loginMapper.toEntity(addLoginDto);

        login.setSenha(passwordEncoder.encode(login.getSenha()));
        return Optional.of(loginMapper.toDto(loginRepository.save(login)));
    }

    @Override
    public Optional<AddLoginDto> atualizar(AddLoginDto addLoginDto) {
        if (loginRepository.existsByUsername(addLoginDto.username())) {
            Optional<Login> login = loginRepository.findById(addLoginDto.username());

            if ((login.isPresent()) && !Objects.equals(login.get().getUsername(), addLoginDto.username())) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Username incorreto!");
            }

            login.get().setSenha(passwordEncoder.encode(addLoginDto.senha()));
            return Optional.ofNullable(loginMapper.toDto(loginRepository.save(login.get())));
        }

        return Optional.empty();
    }

    @Override
    public void excluir(String username) {
        Optional<Login> login = loginRepository.findById(username);

        if (login.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado!");
        }

        loginRepository.deleteById(username);
    }
}
