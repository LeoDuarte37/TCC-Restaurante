package com.restaurante.grupo07.init;

import com.restaurante.grupo07.model.Contato;
import com.restaurante.grupo07.model.Login;
import com.restaurante.grupo07.model.Perfil;
import com.restaurante.grupo07.model.Usuario;
import com.restaurante.grupo07.repository.LoginRepository;
import com.restaurante.grupo07.repository.PerfilRepository;
import com.restaurante.grupo07.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class StartApp implements CommandLineRunner {

    @Autowired
    private PerfilRepository perfilRepository;

    @Autowired
    private LoginRepository loginRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {

        Perfil root = new Perfil(156561L, "ROOT");

        Perfil admin = new Perfil(1L, "ADMIN");

        Perfil caixa = new Perfil(2L, "CAIXA");

        Perfil garcom = new Perfil(3L, "GARCOM");

        Perfil cozinha = new Perfil(4L, "COZINHA");

        List<Perfil> perfisIniciais = new ArrayList<>(Arrays.asList(root, admin, caixa, garcom, cozinha));
        perfisIniciais.forEach(perfil -> perfilRepository.save(perfil));
    }
}
