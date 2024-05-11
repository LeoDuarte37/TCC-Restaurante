package com.restaurante.grupo07.service.impl;

import com.restaurante.grupo07.dto.LogarDto;
import com.restaurante.grupo07.dto.LoginDto;
import com.restaurante.grupo07.dto.SessaoDto;
import com.restaurante.grupo07.dto.mapper.LoginMapper;
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
    public Optional<SessaoDto> autenticar(Optional<LogarDto> logarDto) {
        var credenciais = new UsernamePasswordAuthenticationToken(
                logarDto.get().username(),
                logarDto.get().senha()
        );

        Authentication authentication = authenticationManager.authenticate(credenciais);

        if (authentication.isAuthenticated()) {
            Optional<Login> login = loginRepository.findById(logarDto.get().username());

            if(login.isPresent()) {
                return Optional.of(
                        new SessaoDto(
                                login.get().getUsername(),
                                jwtService.gerarToken(login.get())
                        )
                );
            }
        }

        return Optional.empty();
    }

    @Override
    public Optional<LoginDto> cadastrar(LoginDto loginDto) {
        if (loginRepository.existsByUsername(loginDto.username())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Usuário já existente!");
        }

        Login login = loginMapper.toEntity(loginDto);

        login.setSenha(passwordEncoder.encode(login.getSenha()));
        return Optional.of(loginMapper.toDto(loginRepository.save(login)));
    }

    @Override
    public Optional<LoginDto> atualizar(LoginDto loginDto) {
        if (loginRepository.existsByUsername(loginDto.username())) {
            Optional<Login> login = loginRepository.findById(loginDto.username());

            if ((login.isPresent()) && !Objects.equals(login.get().getUsername(), loginDto.username())) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Username incorreto!");
            }

            login.get().setSenha(passwordEncoder.encode(loginDto.senha()));
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
