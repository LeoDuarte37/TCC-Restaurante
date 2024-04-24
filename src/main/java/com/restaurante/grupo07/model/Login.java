package com.restaurante.grupo07.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@AllArgsConstructor
@RequiredArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "tb_login")
public class Login {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Atributo login é obrigatório!")
    @Size(min = 5)
    private String login;

    @NotBlank(message = "Atributo senha é obrigatório!")
    @Size(min = 5)
    private String senha;

    @NotNull(message = "Atributo usuario é obrigatório!")
    @OneToOne(fetch = FetchType.LAZY)
    private Usuario usuario;

    @NotNull(message = "Atributo perfil é obrigatório!")
    @OneToOne(fetch = FetchType.LAZY)
    private Perfil perfil;
}
