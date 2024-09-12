package com.restaurante.grupo07.infrastructure.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Embeddable
public class Item {

    @ManyToOne
    @NotNull(message = "Atributo produto é obrigatório!")
    @JsonIgnoreProperties(value = {"foto", "descricao", "disponivel", "categoria", "subcategoria"})
    private Produto produto;

    @NotNull(message = "Atributo quantidade é obrigatório!")
    @Min(1)
    private int quantidade;

    private String observacao;
}