package com.restaurante.grupo07.api.mapper;

import com.restaurante.grupo07.api.request.AddRestauranteDto;
import com.restaurante.grupo07.api.response.RestauranteDto;
import com.restaurante.grupo07.infrastructure.model.Restaurante;
import org.springframework.stereotype.Component;

@Component
public class RestauranteMapper {

    public RestauranteDto toDto(Restaurante restaurante) {
        return new RestauranteDto(
                restaurante.getId(),
                restaurante.getNome(),
                restaurante.getCnpj(),
                restaurante.getEndereco(),
                restaurante.getContato()
        );
    }

    public Restaurante toEntity(AddRestauranteDto addRestauranteDto) {
        return Restaurante.builder()
                .nome(addRestauranteDto.nome())
                .cnpj(addRestauranteDto.cnpj())
                .endereco(addRestauranteDto.endereco())
                .contato(addRestauranteDto.contato())
                .build();
    }
}
