package com.restaurante.grupo07.init;

import com.restaurante.grupo07.infrastructure.model.Contato;
import com.restaurante.grupo07.infrastructure.model.Endereco;
import com.restaurante.grupo07.infrastructure.model.Perfil;
import com.restaurante.grupo07.infrastructure.model.Restaurante;
import com.restaurante.grupo07.infrastructure.repository.PerfilRepository;
import com.restaurante.grupo07.infrastructure.repository.RestauranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Component
public class StartApp implements CommandLineRunner {

    @Autowired
    private PerfilRepository perfilRepository;

    @Autowired
    private RestauranteRepository restauranteRepository;

    @Override
    public void run(String... args) throws Exception {

        Perfil root = new Perfil(156561L, "ROOT");

        Perfil admin = new Perfil(1L, "ADMIN");

        Perfil caixa = new Perfil(2L, "CAIXA");

        Perfil garcom = new Perfil(3L, "GARCOM");

        Perfil cozinha = new Perfil(4L, "COZINHA");

        List<Perfil> perfisIniciais = new ArrayList<>(Arrays.asList(root, admin, caixa, garcom, cozinha));
        perfisIniciais.forEach(perfil -> perfilRepository.save(perfil));

        Endereco endereco = new Endereco("Av Vaticano", "João 23", "São Paulo", "SP");

        Contato contato = new Contato("bar07@gmail.com", "1199123456");

        Restaurante restaurante = new Restaurante(1L, UUID.randomUUID(), "Bar 07", "12345678912345", endereco, contato);
        restauranteRepository.save(restaurante);
    }
}
