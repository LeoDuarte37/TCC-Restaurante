package com.restaurante.grupo07.service;


import com.restaurante.grupo07.dto.SubcategoriaDto;

public interface SubcategoriaService {

    SubcategoriaDto adicionar(SubcategoriaDto subcategoriaDto);

    SubcategoriaDto atualizar(SubcategoriaDto subcategoriaDto);

    void excluir(Long id);
}
