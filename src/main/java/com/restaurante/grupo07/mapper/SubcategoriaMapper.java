package com.restaurante.grupo07.mapper;

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
}
