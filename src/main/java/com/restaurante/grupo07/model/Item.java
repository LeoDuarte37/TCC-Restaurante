package com.restaurante.grupo07.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@AllArgsConstructor
@RequiredArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "tb_item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne(fetch = FetchType.LAZY)
    private Produto produto;

    @NotNull(message = "Atributo quantidade é obrigatório!")
    private int quantidade;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties("item")
    private Pedido pedido;
}
