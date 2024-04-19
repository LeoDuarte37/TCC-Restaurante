package com.restaurante.grupo07.resource.dto;

import jakarta.persistence.Embeddable;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Embeddable
@Getter
@Setter
public class CategoriaDto {
    private String nome;
    private String foto;
    private boolean disponivel;
}
