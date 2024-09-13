package com.restaurante.grupo07;

import com.restaurante.grupo07.infrastructure.model.Restaurante;
import com.restaurante.grupo07.infrastructure.model.Contato;
import com.restaurante.grupo07.infrastructure.model.Endereco;
import com.restaurante.grupo07.infrastructure.model.Login;
import com.restaurante.grupo07.infrastructure.model.Usuario;
import com.restaurante.grupo07.infrastructure.model.enumeration.Perfil;
import com.restaurante.grupo07.infrastructure.repository.LoginRepository;
import com.restaurante.grupo07.infrastructure.repository.RestauranteRepository;
import com.restaurante.grupo07.infrastructure.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class StartApp implements CommandLineRunner {

    @Autowired
    private LoginRepository loginRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private RestauranteRepository restauranteRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        if (!loginRepository.existsById("rootroot")) {
            setup();
        }
    }

    private void setup() {
        Restaurante restaurante = Restaurante.builder()
                .id(1L)
                .uuid(UUID.randomUUID())
                .nome("Bar 07")
                .cnpj("12345678912345")
                .contato(new Contato("bar07@gmail.com", "1199123456"))
                .endereco(new Endereco("07", "Zero Sete", "São Paulo", "SP"))
                .build();

        restauranteRepository.save(restaurante);

        Usuario usuario = Usuario.builder()
                .id(1L)
                .nome("Leo")
                .contato(new Contato("leo@gmail.com", "1192129456"))
                .restaurante(restaurante)
                .build();

        loginRepository.save(Login.builder()
                .username("rootroot")
                .senha(passwordEncoder.encode("rootroot"))
                .perfil(Perfil.ROOT)
                .usuario(usuario)
                .build()
        );
    }
}
