package com.restaurante.grupo07.resource.dto;

import jakarta.persistence.Embeddable;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Embeddable
@Getter
@Setter
public class ProdutoDto {
    private String nome;
    private String descricao;
    private String foto;
    private float valor;
    private boolean disponivel;
}
