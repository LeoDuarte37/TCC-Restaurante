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
    @NotBlank(message = "Atributo username é obrigatório!")
    @Size(min = 5)
    private String username;

    @NotBlank(message = "Atributo senha é obrigatório!")
    @Size(min = 5)
    private String senha;

    @NotNull(message = "Atributo usuario é obrigatório!")
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Usuario usuario;

    @NotNull(message = "Atributo perfil é obrigatório!")
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Perfil perfil;
}
