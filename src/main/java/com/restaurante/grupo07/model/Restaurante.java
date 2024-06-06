package com.restaurante.grupo07.model;

import jakarta.persistence.GenerationType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
@Table(name = "tb_restaurante")
public class Restaurante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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
