package com.restaurante.grupo07.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Embeddable
public class Endereco {

    @NotBlank(message = "Atributo rua é obrigatório!")
    private String rua;

    @NotBlank(message = "Atributo bairro é obrigatório!")
    private String bairro;

    @NotBlank(message = "Atributo cidade é obrigatório!")
    private String cidade;

    @NotBlank(message = "Atributo uf é obrigatório!")
    @Size(min = 2, max = 2)
    private String uf;
}
