package com.restaurante.grupo07.resource;

import com.restaurante.grupo07.model.Perfil;
import com.restaurante.grupo07.model.Restaurante;
import com.restaurante.grupo07.resource.dto.PerfilDto;
import com.restaurante.grupo07.resource.dto.RestauranteDto;
import com.restaurante.grupo07.service.PerfilService;
import com.restaurante.grupo07.service.RestauranteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurante")
@RequiredArgsConstructor
public class RestauranteResource {

    private final RestauranteService restauranteService;
    @PostMapping
    public ResponseEntity<Restaurante> adicionarRestaurante(@Valid @RequestBody RestauranteDto restauranteDto) {
        return restauranteService.adicionarRestaurante(restauranteDto);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Restaurante> buscarRestaurantePorId(@PathVariable("id") Long id) {
        return restauranteService.buscarRestaurantePorId(id);
    }
    @GetMapping("/listar")
    public ResponseEntity<List<Restaurante>> listarRestaurantes() {
        return restauranteService.listarRestaurantes();
    }
    @PutMapping("/{id}")
    public ResponseEntity<Restaurante> atualizarRestaurante(@PathVariable("id") Long id, @Valid @RequestBody RestauranteDto restauranteDto) {
        return restauranteService.atualizarRestaurante(id, restauranteDto);
    }
    @DeleteMapping("/{id}")
    public void excluirRestaurante(@PathVariable("id") Long id) {
        restauranteService.excluirRestaurante(id);
    }
}
