package com.restaurante.grupo07.resource.dto;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Embeddable
@Getter
@Setter
public class RestauranteDto {
    private String nome;
    private int cnpj;
    private Long idEndereco;
    private Long idContato;
}
