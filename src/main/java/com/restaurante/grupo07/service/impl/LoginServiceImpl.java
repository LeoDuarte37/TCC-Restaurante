package com.restaurante.grupo07.service.impl;

import com.restaurante.grupo07.dto.LogarDto;
import com.restaurante.grupo07.dto.LoginDto;
import com.restaurante.grupo07.dto.SessaoDto;
import com.restaurante.grupo07.dto.UsuarioDto;
import com.restaurante.grupo07.dto.mapper.LoginMapper;
import com.restaurante.grupo07.dto.mapper.UsuarioMapper;
import com.restaurante.grupo07.model.Login;
import com.restaurante.grupo07.repository.LoginRepository;
import com.restaurante.grupo07.security.JwtService;
import com.restaurante.grupo07.security.SecurityConfig;
import com.restaurante.grupo07.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService {

    @Autowired
    private final LoginRepository loginRepository;

    @Autowired
    private final LoginMapper loginMapper;

    @Autowired
    private final JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

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
                                gerarToken(login.get().getUsername())
                        )
                );
            }
        }

        return Optional.empty();
    }

    @Override
    public Optional<UsuarioDto> cadastrar(LoginDto loginDto) {
        if (loginRepository.existsByUsername(loginDto.username())) {
            return Optional.empty();
        }

        Login login = loginMapper.toEntity(loginDto);

        login.setSenha(criptografarSenha(login.getSenha()));
        return Optional.of(loginMapper.toUsuarioDto(loginRepository.save(login)));
    }

    @Override
    public Optional<LoginDto> atualizar(LoginDto loginDto) {
        if (loginRepository.existsByUsername(loginDto.username())) {
            Optional<Login> login = loginRepository.findById(loginDto.username());

            if ((login.isPresent()) && !Objects.equals(login.get().getUsername(), loginDto.username())) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Username incorreto!");
            }

            login.get().setSenha(criptografarSenha(loginDto.senha()));
            return Optional.ofNullable(loginMapper.toDto(loginRepository.save(login.get())));
        }

        return Optional.empty();
    }

    @Override
    public String criptografarSenha(String senha) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(senha);
    }

    @Override
    public String gerarToken(String username) {
        return SecurityConfig.PREFIX + jwtService.generateToken(username);
    }
}
