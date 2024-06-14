package com.restaurante.grupo07.dto.mapper;

import com.restaurante.grupo07.dto.subcategoria.AddSubcategoriaDto;
import com.restaurante.grupo07.dto.subcategoria.SubcategoriaDto;
import com.restaurante.grupo07.model.Subcategoria;
import org.springframework.stereotype.Component;

@Component
public class SubcategoriaMapper {

    public SubcategoriaDto toDto(Subcategoria subcategoria) {
        return new SubcategoriaDto(
                subcategoria.getId(),
                subcategoria.getNome(),
                subcategoria.isDisponivel(),
                subcategoria.getProduto(),
                subcategoria.getCategoria()
        );
    }

    public Subcategoria toEntity(AddSubcategoriaDto addSubcategoriaDto) {
        return Subcategoria.builder()
                .nome(addSubcategoriaDto.nome())
                .disponivel(addSubcategoriaDto.disponivel())
                .categoria(addSubcategoriaDto.categoria())
                .build();
    }
}
