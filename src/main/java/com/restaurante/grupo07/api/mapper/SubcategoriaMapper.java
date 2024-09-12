package com.restaurante.grupo07.api.mapper;

import com.restaurante.grupo07.api.response.SubcategoriaDto;
import com.restaurante.grupo07.infrastructure.model.Subcategoria;
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
