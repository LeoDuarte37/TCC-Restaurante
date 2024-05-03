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

    @NotNull(message = "atributo numero é obrigatório!")
    private Long numero;

    @NotNull(message = "Atributo restaurante é obrigatório!")
    @ManyToOne
    private Restaurante restaurante;

    @Builder.Default
    private boolean chamarGarcom = false;

    @Enumerated(EnumType.STRING)
    private StatusMesa status;

    public Mesa(Long numero, Restaurante restaurante, String status) {
        this.numero = numero;
        this.restaurante = restaurante;
        this.status = StatusMesa.doStatus(status);
    }
}