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
public class EnderecoDto {
    private String rua;
    private String bairro;
    private String cidade;
    private String uf;
}
