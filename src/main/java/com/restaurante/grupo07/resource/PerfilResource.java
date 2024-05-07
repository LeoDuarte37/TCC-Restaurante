package com.restaurante.grupo07.resource;

import com.restaurante.grupo07.model.Perfil;
import com.restaurante.grupo07.service.PerfilService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Perfil adicionar(@Valid @RequestBody Perfil perfil) {
        return perfilService.adicionar(perfil);
    }

    @GetMapping("/{nivel}")
    public Perfil buscarPorId(@PathVariable("nivel") @NotNull Long nivel) {
        return perfilService.buscarPorId(nivel);
    }

    @GetMapping("/listar")
    public List<Perfil> listar() {
        return perfilService.listar();
    }

    @PutMapping
    @Transactional
    public Perfil atualizar(@Valid @RequestBody Perfil perfil) {
        return perfilService.atualizar(perfil);
    }

    @DeleteMapping("/{nivel}")
    @Transactional
    public void excluir(@PathVariable("nivel") @NotNull Long nivel) {
        perfilService.excluir(nivel);
    }
}