package com.restaurante.grupo07.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.restaurante.grupo07.enumeration.StatusPedido;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.UpdateTimestamp;

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

    @NotNull(message = "Atributo mesa é obrigatório!")
    @ManyToOne
    private Mesa mesa;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pedido", cascade = {CascadeType.ALL, CascadeType.PERSIST})
    @JsonIgnoreProperties("pedido")
    private List<Item> item;

    @UpdateTimestamp
    private LocalDateTime data;

    @Enumerated(EnumType.STRING)
    private StatusPedido status;

    public Pedido(Mesa mesa, List<Item> item) {
        this.mesa = mesa;
        this.item = item;
        this.status = StatusPedido.doStatus("R");
    }
}
