package com.restaurante.grupo07.dto.mapper;

import com.restaurante.grupo07.dto.ProdutoDto;
import com.restaurante.grupo07.model.Produto;
import com.restaurante.grupo07.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProdutoMapper {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public ProdutoDto toDto(Produto produto) {
        return new ProdutoDto(
                produto.getId(),
                produto.getNome(),
                produto.getDescricao(),
                produto.getFoto(),
                produto.getValor(),
                produto.isDisponivel(),
                produto.getCategoria()
        );
    }

    public Produto toEntity(ProdutoDto produtoDto) {
        return new Produto(
                produtoDto.nome(),
                produtoDto.descricao(),
                produtoDto.foto(),
                produtoDto.valor(),
                produtoDto.disponivel(),
                produtoDto.categoria()
        );

//        return Produto.builder()
//                .nome(produtoDto.nome())
//                .descricao(produtoDto.descricao())
//                .foto(produtoDto.foto())
//                .valor(produtoDto.valor())
//                .disponivel(produtoDto.disponivel())
//                .categoria(categoriaRepository.getReId(produtoDto.categoria()))
//                .build();
    }
}
