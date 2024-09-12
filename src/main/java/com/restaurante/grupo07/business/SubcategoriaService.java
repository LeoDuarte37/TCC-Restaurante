package com.restaurante.grupo07.business;

import com.restaurante.grupo07.api.request.AtualizarCardapioDto;
import com.restaurante.grupo07.api.request.AddSubcategoriaDto;
import com.restaurante.grupo07.api.response.SubcategoriaDto;

public interface SubcategoriaService {

    SubcategoriaDto adicionar(AddSubcategoriaDto addSubcategoriaDto);

    SubcategoriaDto atualizar(AtualizarCardapioDto atualizarCardapioDto);

    void excluir(Long id);
}
