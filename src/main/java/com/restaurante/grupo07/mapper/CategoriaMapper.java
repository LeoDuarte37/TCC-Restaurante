package com.restaurante.grupo07.mapper;

import com.restaurante.grupo07.dto.categoria.CategoriaDto;
import com.restaurante.grupo07.model.Categoria;
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
