package com.restaurante.grupo07.model;

import com.restaurante.grupo07.enumeration.StatusMesa;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
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

    private float total;

    private boolean chamarGarcom;

    @NotNull(message = "Atributo restaurante é obrigatório!")
    @OneToOne(fetch = FetchType.LAZY)
    private Restaurante restaurante;

    @NotBlank(message = "Atributo status é obrigatório!")
    @Enumerated(EnumType.STRING)
    private StatusMesa status;
}