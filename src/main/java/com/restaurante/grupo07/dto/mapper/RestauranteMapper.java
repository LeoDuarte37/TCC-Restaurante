package com.restaurante.grupo07.dto.mapper;

import com.restaurante.grupo07.dto.RestauranteDto;
import com.restaurante.grupo07.model.Restaurante;
import org.springframework.stereotype.Component;

@Component
public class RestauranteMapper {

    public RestauranteDto toDto(Restaurante restaurante) {
        return new RestauranteDto(
                restaurante.getUuid().toString(),
                restaurante.getNome(),
                restaurante.getCnpj(),
                restaurante.getEndereco(),
                restaurante.getContato()
        );
    }

    public Restaurante toEntity(RestauranteDto restauranteDto) {
        return Restaurante.builder()
                .nome(restauranteDto.nome())
                .cnpj(restauranteDto.cnpj())
                .endereco(restauranteDto.endereco())
                .contato(restauranteDto.contato())
                .build();
    }
}
