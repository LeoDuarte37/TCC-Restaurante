package com.restaurante.grupo07.api.mapper;

import com.restaurante.grupo07.api.response.CategoriaDto;
import com.restaurante.grupo07.infrastructure.model.Categoria;
import org.springframework.stereotype.Component;

@Component
public class CategoriaMapper {

    public CategoriaDto toDto(Categoria categoria) {
        return new CategoriaDto(
                categoria.getId(),
                categoria.getNome(),
                categoria.isDisponivel(),
                categoria.getSubcategoria()
        );
    }
}
