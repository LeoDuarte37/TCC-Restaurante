package com.restaurante.grupo07.security;

import com.restaurante.grupo07.model.Login;
import com.restaurante.grupo07.repository.LoginRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private LoginRepository loginRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Login user = loginRepository.findByUsername(username);

        if (user == null) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN);
        }

        Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();

        authorities.add(new SimpleGrantedAuthority("ROLE_" + user.getUsuario().getPerfil().getNome()));

        UserDetails userDetails = new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getSenha(),
                authorities
        );

        return userDetails;
    }
}
