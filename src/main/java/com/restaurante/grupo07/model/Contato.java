package com.restaurante.grupo07.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@AllArgsConstructor
@RequiredArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "tb_contato")
public class Contato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Atributo email é obrigatório!")
    @Email(message = "Atributo email deverá ser um email válido!")
    private String email;

    @NotNull(message = "Atributo telefone é obrigatório!")
    private String telefone;
}
