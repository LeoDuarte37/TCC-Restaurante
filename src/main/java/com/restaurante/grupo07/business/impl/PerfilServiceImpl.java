package com.restaurante.grupo07.business.impl;

import com.restaurante.grupo07.infrastructure.model.Perfil;
import com.restaurante.grupo07.infrastructure.repository.PerfilRepository;
import com.restaurante.grupo07.business.PerfilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PerfilServiceImpl implements PerfilService {

    @Autowired
    private PerfilRepository perfilRepository;

    @Override
    public Perfil adicionar(Perfil perfil) {
        if (perfilRepository.existsById(perfil.getNivel())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Já existe um perfil com o nivel de acesso");
        }

        return perfilRepository.save(perfil);
    }

    @Override
    public Perfil buscarPorId(Long nivel) {
        return perfilRepository.findById(nivel)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Perfil não encontrado!"));
    }

    @Override
    public List<Perfil> listar() {
        return new ArrayList<>(perfilRepository.findAll());
    }

    @Override
    public Perfil atualizar(Perfil perfil) {
        return perfilRepository.findById(perfil.getNivel())
                .map(entity -> {
                    entity.setNome(perfil.getNome());
                    return perfilRepository.save(entity);
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Perfil não encontrado!"));
    }

    @Override
    public void excluir(Long nivel) {
        Optional<Perfil> perfil = perfilRepository.findById(nivel);

        if (perfil.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Perfil não encontrado!");
        }

        perfilRepository.deleteById(nivel);
    }
}
