package com.restaurante.grupo07.resource;

import com.restaurante.grupo07.model.Perfil;
import com.restaurante.grupo07.resource.dto.PerfilDto;
import com.restaurante.grupo07.service.PerfilService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/perfil")
@RequiredArgsConstructor
public class PerfilResource {

    private final PerfilService perfilService;
    @PostMapping
    public ResponseEntity<Perfil> adicionarPerfil(@Valid @RequestBody PerfilDto perfilDto) {
        return perfilService.adicionarPerfil(perfilDto);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Perfil> buscarPerfilPorId(@PathVariable("id") Long id) {
        return perfilService.buscarPerfilPorId(id);
    }
    @GetMapping("/listar")
    public ResponseEntity<List<Perfil>> listarPerfis() {
        return perfilService.listarPerfis();
    }
    @PutMapping("/{id}")
    public ResponseEntity<Perfil> atualizarPerfil(@PathVariable("id") Long id, @Valid @RequestBody PerfilDto perfilDto) {
        return perfilService.atualizarPerfil(id, perfilDto);
    }
    @DeleteMapping("/{id}")
    public void excluirPerfil(@PathVariable("id") Long id) {
        perfilService.excluirPerfil(id);
    }
}
