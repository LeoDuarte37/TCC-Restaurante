package com.restaurante.grupo07.resource;

import com.restaurante.grupo07.model.Perfil;
import com.restaurante.grupo07.dto.PerfilDto;
import com.restaurante.grupo07.service.PerfilService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/perfil")
@RequiredArgsConstructor
public class PerfilResource {

    @Autowired
    private final PerfilService perfilService;
    @PostMapping
    @Transactional
    public ResponseEntity<Perfil> adicionar(@Valid @RequestBody PerfilDto perfilDto) {
        return perfilService.adicionar(perfilDto);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Perfil> buscarPorId(@PathVariable("id") @NotNull Long id) {
        return perfilService.buscarPorId(id);
    }
    @GetMapping("/listar")
    public ResponseEntity<List<Perfil>> listar() {
        return perfilService.listar();
    }
    @PutMapping
    @Transactional
    public ResponseEntity<Perfil> atualizar(@Valid @RequestBody PerfilDto perfilDto) {
        return perfilService.atualizar(perfilDto);
    }
    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable("id") @NotNull Long id) {
        perfilService.excluir(id);
    }
}
