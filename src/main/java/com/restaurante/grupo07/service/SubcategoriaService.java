package com.restaurante.grupo07.service;

import com.restaurante.grupo07.dto.AtualizarCardapioDto;
import com.restaurante.grupo07.dto.subcategoria.AddSubcategoriaDto;
import com.restaurante.grupo07.dto.subcategoria.SubcategoriaDto;

public interface SubcategoriaService {

    SubcategoriaDto adicionar(AddSubcategoriaDto addSubcategoriaDto);

    SubcategoriaDto atualizar(AtualizarCardapioDto atualizarCardapioDto);

    void excluir(Long id);
}
