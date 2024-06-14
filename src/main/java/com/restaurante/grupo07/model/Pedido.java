package com.restaurante.grupo07.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.restaurante.grupo07.enumeration.StatusPedido;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
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

    @ManyToOne
    @NotNull(message = "Atributo mesa é obrigatório!")
    @JsonIgnoreProperties(value = {"chamarGarcom", "status"})
    private Mesa mesa;

    @NotNull
    @ElementCollection
    @CollectionTable(name = "tb_pedido_item")
    private List<Item> item = new ArrayList<>();

    @JsonFormat(pattern="dd/MM/yyyy HH:mm")
    @UpdateTimestamp
    private LocalDateTime data;

    @Enumerated(EnumType.STRING)
    private StatusPedido status;
}
