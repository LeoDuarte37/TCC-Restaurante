package com.restaurante.grupo07.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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

    @ManyToOne
    @NotNull(message = "Atributo restaurante é obrigatório!")
    @JsonIgnoreProperties(value = {"cnpj", "endereco", "contato"})
    private Restaurante restaurante;

    @Builder.Default
    private boolean chamarGarcom = false;

    @Enumerated(EnumType.STRING)
    private StatusMesa status;
}