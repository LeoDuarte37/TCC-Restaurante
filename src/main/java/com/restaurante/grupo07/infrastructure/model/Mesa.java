package com.restaurante.grupo07.infrastructure.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.restaurante.grupo07.infrastructure.model.enumeration.StatusMesa;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@RequiredArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "tb_mesa")
@JsonIgnoreProperties("pedido")
public class Mesa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "atributo numero é obrigatório!")
    private Long numero;

    @ManyToOne
    @NotNull(message = "Atributo restaurante é obrigatório!")
    @JsonIgnoreProperties(value = {"chamarGarcom", "id", "status", "cnpj", "endereco", "contato"})
    private Restaurante restaurante;

    @OneToMany(cascade = { CascadeType.ALL, CascadeType.REMOVE }, mappedBy = "mesa")
    private List<Pedido> pedido;

    @Builder.Default
    private boolean chamarGarcom = false;

    @Enumerated(EnumType.STRING)
    private StatusMesa status;
}