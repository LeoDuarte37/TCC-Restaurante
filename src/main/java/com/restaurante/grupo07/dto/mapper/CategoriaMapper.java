package com.restaurante.grupo07.dto.mapper;

import com.restaurante.grupo07.dto.categoria.AddCategoriaDto;
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

    public Categoria toEntity(AddCategoriaDto addCategoriaDto) {
        return Categoria.builder()
                .nome(addCategoriaDto.nome())
                .disponivel(addCategoriaDto.disponivel())
                .restaurante(addCategoriaDto.restaurante())
                .build();
    }
}
