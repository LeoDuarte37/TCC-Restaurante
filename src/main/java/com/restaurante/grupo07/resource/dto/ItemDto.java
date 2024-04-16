package com.restaurante.grupo07.resource.dto;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Embeddable
@Getter
@Setter
public class ItemDto {
    private Long idProduto;
    private int quantidade;
    private Long idPedido;
}
