package com.restaurante.grupo07.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@AllArgsConstructor
@RequiredArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "tb_endereco")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Atributo rua é obrigatório!")
    private String rua;

    @NotBlank(message = "Atributo bairro é obrigatório!")
    private String bairro;

    @NotBlank(message = "Atributo cidade é obrigatório!")
    private String cidade;

    @NotBlank(message = "Atributo uf é obrigatório!")
    @Size(min = 2, max = 2)
    private String uf;

    public Endereco(String rua, String bairro, String cidade, String uf) {
        this.rua = rua;
        this.bairro = bairro;
        this.cidade = cidade;
        this.uf = uf;
    }
}
