package com.restaurante.grupo07.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
    private float valor;

    @NotNull(message = "Atributo disponivel é obrigatório!")
    private boolean disponivel;

    @NotNull(message = "Atributo categoria é obrigatório!")
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties("produto")
    private Categoria categoria;

    public Produto(String nome, String descricao, String foto, float valor, boolean disponivel, Categoria categoria) {
        this.nome = nome;
        this.descricao = descricao;
        this.foto = foto;
        this.valor = valor;
        this.disponivel = disponivel;
        this.categoria = categoria;
    }
}
