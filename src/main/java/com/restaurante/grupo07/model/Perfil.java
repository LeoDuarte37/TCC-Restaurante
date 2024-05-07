package com.restaurante.grupo07.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@RequiredArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "tb_perfil")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Perfil {

    @Id
    @NotNull
    private Long nivel;

    @NotBlank
    private String nome;
}
