package com.restaurante.grupo07;

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
        admin.setNome("Administrador");

        Perfil caixa = new Perfil();
        caixa.setNivel(2L);
        caixa.setNome("Caixa");

        Perfil garcom = new Perfil();
        garcom.setNivel(3L);
        garcom.setNome("Garçom");

        Perfil cozinha = new Perfil();
        cozinha.setNivel(4L);
        cozinha.setNome("Cozinha");


        List<Perfil> perfisIniciais = new ArrayList<>(Arrays.asList(admin, caixa, garcom, cozinha));

        perfisIniciais.forEach(perfil -> perfilRepository.save(perfil));
    }
}
