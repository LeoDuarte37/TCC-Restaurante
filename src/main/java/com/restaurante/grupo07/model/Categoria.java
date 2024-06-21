package com.restaurante.grupo07.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@RequiredArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "tb_categoria")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Atributo nome é obrigatório!")
    private String nome;

    @NotNull(message = "Atributo disponivel é obrigatório!")
    private boolean disponivel;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "categoria", cascade = {CascadeType.ALL, CascadeType.REMOVE})
    private List<Subcategoria> subcategoria;

    @NotNull
    @ManyToOne
    private Restaurante restaurante;

    public Categoria(String nome, boolean disponivel, Restaurante restaurante) {
        this.nome = nome;
        this.disponivel = disponivel;
        this.restaurante = restaurante;
    }
}
