package com.restaurante.grupo07.model;

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
@Table(name = "tb_perfil")
public class Perfil {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Atributo nivel é obrigatório!")
    private int nivel;

    @NotBlank(message = "Atributo nome é obrigatório!")
    private String nome;

    public Perfil(int nivel, String nome) {
        this.nivel = nivel;
        this.nome = nome;
    }
}
