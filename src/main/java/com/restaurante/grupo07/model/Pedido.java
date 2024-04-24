package com.restaurante.grupo07.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.restaurante.grupo07.enumeration.StatusPedido;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
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
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Mesa mesa;

    @NotNull(message = "Atributo item é obrigatório!")
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pedido", cascade = CascadeType.REMOVE)
    @JsonIgnoreProperties("pedido")
    private List<Item> item;

    private float total;

    @UpdateTimestamp
    private LocalDateTime data;

    @NotBlank(message = "Atributo status é obrigatório!")
    @Enumerated(EnumType.STRING)
    private StatusPedido status;
}
