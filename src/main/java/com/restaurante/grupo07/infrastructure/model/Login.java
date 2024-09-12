package com.restaurante.grupo07.infrastructure.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
@Table(name = "tb_login")
public class Login {

    @Id
    @Column(unique = true)
    @NotBlank(message = "Atributo username é obrigatório!")
    @Size(min = 5)
    private String username;

    @NotBlank(message = "Atributo senha é obrigatório!")
    @Size(min = 5)
    private String senha;

    @NotNull(message = "Atributo usuario é obrigatório!")
    @OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL, CascadeType.PERSIST}, orphanRemoval = true)
    private Usuario usuario;

    @NotNull
    @ManyToOne
    private Perfil perfil;
}
