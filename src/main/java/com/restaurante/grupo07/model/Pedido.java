package com.restaurante.grupo07.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.restaurante.grupo07.enumeration.StatusPedido;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static org.hibernate.annotations.CascadeType.ALL;

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
    @CollectionTable(name = "tb_pedido_item",
            foreignKey = @ForeignKey(name = "pedido_id",
            foreignKeyDefinition = "foreign key (pedido_id) references tb_pedido (id) on delete cascade"))
    @JsonIgnoreProperties("subcategoria")
    private List<Item> item = new ArrayList<>();

    @Builder.Default
    private LocalDateTime data = LocalDateTime.now();

    @Enumerated(EnumType.STRING)
    @Builder.Default
    private StatusPedido status = StatusPedido.REALIZADO;
}
