package com.restaurante.grupo07.dto.mapper;

import com.restaurante.grupo07.dto.produto.AddProdutoDto;
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

    public Produto toEntity(AddProdutoDto addProdutoDto) {
        return Produto.builder()
                .nome(addProdutoDto.nome())
                .descricao(addProdutoDto.descricao())
                .foto(addProdutoDto.foto())
                .valor(addProdutoDto.valor())
                .disponivel(addProdutoDto.disponivel())
                .subcategoria(addProdutoDto.subcategoria())
                .build();
    }
}
