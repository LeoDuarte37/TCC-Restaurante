package com.restaurante.grupo07.resource.dto;

import com.restaurante.grupo07.model.Item;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Embeddable
@Getter
@Setter
public class PedidoDto {
    private Long idMesa;
    private List<Item> itens;
    private float valor;
    private String status;
}
