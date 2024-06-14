package com.restaurante.grupo07.dto.mapper;

import com.restaurante.grupo07.dto.SubcategoriaDto;
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

    public Subcategoria toEntity(SubcategoriaDto subcategoriaDto) {
        return Subcategoria.builder()
                .nome(subcategoriaDto.nome())
                .disponivel(subcategoriaDto.disponivel())
                .categoria(subcategoriaDto.categoria())
                .build();
    }
}
