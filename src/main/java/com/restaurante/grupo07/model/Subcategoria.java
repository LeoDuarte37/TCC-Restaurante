package com.restaurante.grupo07.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@RequiredArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "tb_subcategoria")
public class Subcategoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nome;

    @NotNull
    private boolean disponivel;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "subcategoria", cascade = CascadeType.REMOVE)
    @JsonIgnoreProperties("subcategoria")
    private List<Produto> produto;

    @NotNull
    @ManyToOne
    @JsonIgnoreProperties("subcategoria")
    private Categoria categoria;

    public Subcategoria(String nome, boolean disponivel, Categoria categoria) {
        this.nome = nome;
        this.disponivel = disponivel;
        this.categoria = categoria;
    }
}
