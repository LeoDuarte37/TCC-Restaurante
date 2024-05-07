package com.restaurante.grupo07.model;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Embeddable
public class Contato {

    @NotBlank(message = "Atributo email é obrigatório!")
    @Email(message = "Atributo email deverá ser um email válido!")
    private String email;

    @NotBlank(message = "Atributo telefone é obrigatório!")
    private String telefone;
}
