package com.restaurante.grupo07.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
    @Size(max = 25)
    private String nome;

    @NotBlank(message = "Atributo cnpj é obrigatório!")
    @Size(min = 14, max = 14)
    private String cnpj;

    @NotNull(message = "Atributo endereco é obrigatório!")
    @OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL, CascadeType.PERSIST})
    private Endereco endereco;

    @NotNull(message = "Atributo contato é obrigatório!")
    @OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL, CascadeType.PERSIST})
    private Contato contato;
}
