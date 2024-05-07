package com.restaurante.grupo07.init;

import com.restaurante.grupo07.model.Perfil;
import com.restaurante.grupo07.repository.PerfilRepository;
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

    @Override
    public void run(String... args) throws Exception {

        Perfil admin = new Perfil();
        admin.setNivel(1L);
        admin.setNome("ADMINISTRADOR");

        Perfil caixa = new Perfil();
        caixa.setNivel(2L);
        caixa.setNome("CAIXA");

        Perfil garcom = new Perfil();
        garcom.setNivel(3L);
        garcom.setNome("GARCOM");

        Perfil cozinha = new Perfil();
        cozinha.setNivel(4L);
        cozinha.setNome("COZINHA");

        List<Perfil> perfisIniciais = new ArrayList<>(Arrays.asList(admin, caixa, garcom, cozinha));

        perfisIniciais.forEach(perfil -> perfilRepository.save(perfil));
    }
}
