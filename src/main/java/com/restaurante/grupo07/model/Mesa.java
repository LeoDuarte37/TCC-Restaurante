package com.restaurante.grupo07.model;

import com.restaurante.grupo07.enumeration.StatusMesa;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@AllArgsConstructor
@RequiredArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "tb_mesa")
public class Mesa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Atributo numero é obrigatório!")
    private int numero;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "mesa", cascade = CascadeType.REMOVE)
    @JsonIgnoreProperties("mesa")
    private List<Pedido> pedidos;

    @NotNull(message = "Atributo total é obrigatório!")
    private float total;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "Atributo status é obrigatório!")
    @Builder.Default
    private StatusMesa status = StatusMesa.DISPONIVEL;
}