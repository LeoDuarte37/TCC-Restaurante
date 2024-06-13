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
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class StartApp implements CommandLineRunner {

    @Autowired
    private PerfilRepository perfilRepository;

    @Autowired
    private ContatoRepository contatoRepository;
    
    @Autowired
    private LoginRepository loginRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public void run(String... args) throws Exception {

        Perfil root = new Perfil(156561L, "ROOT");

        Perfil admin = new Perfil(1L, "ADMIN");

        Perfil caixa = new Perfil(2L, "CAIXA");

        Perfil garcom = new Perfil(3L, "GARCOM");

        Perfil cozinha = new Perfil(4L, "COZINHA");

        List<Perfil> perfisIniciais = new ArrayList<>(Arrays.asList(root, admin, caixa, garcom, cozinha));
        perfisIniciais.forEach(perfil -> perfilRepository.save(perfil));
        
        Contato contato = new Contato(1L, "leonardo.r@gmail.com", "11 92564184");
        contatoRepository.save(contato);
        
        Usuario usuario = new Usuario(1L, "Root", contato);
        usuarioRepository.save(usuario);
        
        Login login = new Login("Root", "root@123", usuario, root);
        loginRepository.save(login); 
    }
}
