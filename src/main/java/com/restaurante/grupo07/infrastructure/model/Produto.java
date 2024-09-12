package com.restaurante.grupo07.infrastructure.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@RequiredArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "tb_produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Atributo nome é obrigatório!")
    private String nome;

    @NotBlank(message = "Atributo descricao é obrigatório!")
    private String descricao;

    @NotBlank(message = "Atributo foto é obrigatório!")
    private String foto;

    @NotNull(message = "Atributo valor é obrigatório!")
    private double valor;

    @NotNull(message = "Atributo disponivel é obrigatório!")
    private boolean disponivel;

    @NotNull
    @ManyToOne
    @JsonIgnoreProperties("produto")
    private Subcategoria subcategoria;

    public Produto(String nome, String descricao, String foto, double valor, boolean disponivel, Subcategoria subcategoria) {
        this.nome = nome;
        this.descricao = descricao;
        this.foto = foto;
        this.valor = valor;
        this.disponivel = disponivel;
        this.subcategoria = subcategoria;
    }
}
