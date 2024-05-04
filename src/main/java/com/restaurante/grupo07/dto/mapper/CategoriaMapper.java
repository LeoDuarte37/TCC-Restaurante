package com.restaurante.grupo07.dto.mapper;

import com.restaurante.grupo07.dto.CategoriaDto;
import com.restaurante.grupo07.model.Categoria;
import org.springframework.stereotype.Component;

@Component
public class CategoriaMapper {

    public CategoriaDto toDto(Categoria categoria) {
        return new CategoriaDto(
                categoria.getId(),
                categoria.getNome(),
                categoria.getFoto(),
                categoria.isDisponivel(),
                categoria.getProduto()
        );
    }

    public Categoria toEntity(CategoriaDto categoriaDto) {
        return Categoria.builder()
                .nome(categoriaDto.nome())
                .foto(categoriaDto.foto())
                .disponivel(categoriaDto.disponivel())
                .build();
    }
}
