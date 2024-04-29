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
    @NotNull(message = "atributo numero é obrigatório!")
    private Long numero;

    @Builder.Default
    private boolean chamarGarcom = false;

    @NotNull(message = "Atributo restaurante é obrigatório!")
    @ManyToOne(fetch = FetchType.LAZY)
    private Restaurante restaurante;

    @Enumerated(EnumType.STRING)
    @Builder.Default
    private StatusMesa status = StatusMesa.DISPONIVEL;
}