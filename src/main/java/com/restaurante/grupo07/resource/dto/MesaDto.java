package com.restaurante.grupo07.resource.dto;

import jakarta.persistence.Embeddable;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Embeddable
@Getter
@Setter
public class MesaDto {
    private int numero;
    private Long idRestaurante;
    private String status;
}
