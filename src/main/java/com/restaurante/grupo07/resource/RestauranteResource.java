package com.restaurante.grupo07.resource;

import com.restaurante.grupo07.dto.RestauranteDto;
import com.restaurante.grupo07.service.RestauranteService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurante")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class RestauranteResource {

    @Autowired
    private RestauranteService restauranteService;

    @PostMapping
    @Transactional
    public RestauranteDto adicionar(@Valid @RequestBody RestauranteDto restauranteDto) {
        return restauranteService.adicionar(restauranteDto);
    }

    @GetMapping("/{id}")
    public RestauranteDto buscarPorId(@PathVariable("id") @NotNull Long id) {
        return restauranteService.buscarPorId(id);
    }

    @GetMapping("/listar")
    public List<RestauranteDto> listar() {
        return restauranteService.listar();
    }

    @PutMapping
    @Transactional
    public RestauranteDto atualizar(@Valid @RequestBody RestauranteDto restauranteDto) {
        return restauranteService.atualizar(restauranteDto);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable("id") @NotNull Long id) {
        restauranteService.excluir(id);
    }
}
