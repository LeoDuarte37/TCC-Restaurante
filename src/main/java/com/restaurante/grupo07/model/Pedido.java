package com.restaurante.grupo07.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.restaurante.grupo07.enumeration.StatusPedido;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.UniqueElements;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@RequiredArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "tb_pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @NotNull(message = "Atributo mesa é obrigatório!")
    @JsonIgnoreProperties(value = {"chamarGarcom", "status"})
    private Mesa mesa;

    @NotNull
    @ElementCollection
    @CollectionTable(name = "TB_PEDIDO_ITEM")
    private List<Item> item = new ArrayList<>();

    @UpdateTimestamp
    private LocalDateTime data;

    @Enumerated(EnumType.STRING)
    private StatusPedido status;
}
