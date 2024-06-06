package com.restaurante.grupo07.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.restaurante.grupo07.enumeration.StatusPedido;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
    @CollectionTable(name = "TB_PEDIDO_ITEM")
    private List<Item> item = new ArrayList<>();

    @JsonFormat(pattern="dd/MM/yyyy")
    @UpdateTimestamp
    private LocalDateTime data;

    @Enumerated(EnumType.STRING)
    private StatusPedido status;
}
