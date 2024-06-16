package com.restaurante.grupo07.mapper;

import com.restaurante.grupo07.dto.produto.ProdutoDto;
import com.restaurante.grupo07.model.Produto;
import org.springframework.stereotype.Component;

@Component
public class ProdutoMapper {

    public ProdutoDto toDto(Produto produto) {
        return new ProdutoDto(
                produto.getId(),
                produto.getNome(),
                produto.getDescricao(),
                produto.getFoto(),
                produto.getValor(),
                produto.isDisponivel(),
                produto.getSubcategoria()
        );
    }
}
