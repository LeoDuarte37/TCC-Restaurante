package com.restaurante.grupo07.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.br.CNPJ;

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
    private String nome;

    @NotNull(message = "Atributo cnpj é obrigatório!")
    @CNPJ
    private int cnpj;

    @NotNull(message = "Atributo endereco é obrigatório!")
    @OneToOne(fetch = FetchType.LAZY)
    private Endereco endereco;

    @NotNull(message = "Atributo contato é obrigatório!")
    @OneToOne(fetch = FetchType.LAZY)
    private Contato contato;
}
