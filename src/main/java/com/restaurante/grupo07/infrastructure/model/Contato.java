package com.restaurante.grupo07.infrastructure.model;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
