package com.restaurante.grupo07.dto.mapper;

import com.restaurante.grupo07.dto.ProdutoDto;
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

    public Produto toEntity(ProdutoDto produtoDto) {
        return Produto.builder()
                .nome(produtoDto.nome())
                .descricao(produtoDto.descricao())
                .foto(produtoDto.foto())
                .valor(produtoDto.valor())
                .disponivel(produtoDto.disponivel())
                .subcategoria(produtoDto.subCategoria())
                .build();
    }
}
