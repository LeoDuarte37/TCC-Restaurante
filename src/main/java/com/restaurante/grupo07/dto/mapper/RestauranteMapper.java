package com.restaurante.grupo07.dto.mapper;

import com.restaurante.grupo07.dto.RestauranteDto;
import com.restaurante.grupo07.model.Restaurante;
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

    public Restaurante toEntity(RestauranteDto restauranteDto) {
        return new Restaurante(
                restauranteDto.nome(),
                restauranteDto.cnpj(),
                restauranteDto.endereco(),
                restauranteDto.contato()
        );
    }
}
