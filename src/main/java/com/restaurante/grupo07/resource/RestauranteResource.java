package com.restaurante.grupo07.resource;

import com.restaurante.grupo07.dto.restaurante.AddRestauranteDto;
import com.restaurante.grupo07.dto.restaurante.RestauranteDto;
import com.restaurante.grupo07.service.RestauranteService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurante")
public class RestauranteResource {

    @Autowired
    private RestauranteService restauranteService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Transactional
    public RestauranteDto adicionar(@Valid @RequestBody AddRestauranteDto addRestauranteDto) {
        return restauranteService.adicionar(addRestauranteDto);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public RestauranteDto buscarPorId(@PathVariable("id") @NotNull Long id) {
        return restauranteService.buscarPorId(id);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    @Transactional
    public RestauranteDto atualizar(@Valid @RequestBody RestauranteDto restauranteDto) {
        return restauranteService.atualizar(restauranteDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Transactional
    public void excluir(@PathVariable("id") @NotNull Long id) {
        restauranteService.excluir(id);
    }
}
