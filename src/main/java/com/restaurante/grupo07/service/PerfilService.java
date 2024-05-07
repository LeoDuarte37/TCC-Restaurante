package com.restaurante.grupo07.service;

import com.restaurante.grupo07.model.Perfil;

import java.util.List;

public interface PerfilService {
    Perfil adicionar(Perfil perfil);

    Perfil buscarPorId(Long nivel);

    List<Perfil> listar();

    Perfil atualizar(Perfil perfil);

    void excluir(Long nivel);
}
