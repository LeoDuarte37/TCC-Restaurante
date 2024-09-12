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

import java.util.UUID;

@AllArgsConstructor
@RequiredArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "tb_restaurante")
public class Restaurante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Builder.Default
    private UUID uuid = UUID.randomUUID();

    @NotBlank(message = "Atributo nome é obrigatório!")
    @Size(max = 25)
    private String nome;

    @NotBlank(message = "Atributo cnpj é obrigatório!")
    @Size(min = 14, max = 14)
    private String cnpj;

    @NotNull(message = "Atributo endereco é obrigatório!")
    @Embedded
    private Endereco endereco;

    @NotNull(message = "Atributo contato é obrigatório!")
    @Embedded
    private Contato contato;
}
