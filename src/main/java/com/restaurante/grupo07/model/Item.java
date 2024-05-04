package com.restaurante.grupo07.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Embeddable
public class Item {

    @ManyToOne
    @NotNull(message = "Atributo produto é obrigatório!")
    @JsonIgnoreProperties(value = {"foto", "descricao", "disponivel", "categoria"})
    private Produto produto;

    @NotNull(message = "Atributo quantidade é obrigatório!")
    @Min(1)
    private int quantidade;

    private String observacao;
}
