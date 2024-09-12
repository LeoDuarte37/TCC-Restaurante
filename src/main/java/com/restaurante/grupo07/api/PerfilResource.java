package com.restaurante.grupo07.api;

import com.restaurante.grupo07.infrastructure.model.Perfil;
import com.restaurante.grupo07.business.PerfilService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/perfil")
public class PerfilResource {

    @Autowired
    private PerfilService perfilService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Transactional
    public Perfil adicionar(@Valid @RequestBody Perfil perfil) {
        return perfilService.adicionar(perfil);
    }

    @GetMapping("/{nivel}")
    @ResponseStatus(HttpStatus.OK)
    public Perfil buscarPorId(@PathVariable("nivel") @NotNull Long nivel) {
        return perfilService.buscarPorId(nivel);
    }

    @GetMapping("/listar")
    @ResponseStatus(HttpStatus.OK)
    public List<Perfil> listar() {
        return perfilService.listar();
    }

    @PutMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    @Transactional
    public Perfil atualizar(@Valid @RequestBody Perfil perfil) {
        return perfilService.atualizar(perfil);
    }

    @DeleteMapping("/{nivel}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Transactional
    public void excluir(@PathVariable("nivel") @NotNull Long nivel) {
        perfilService.excluir(nivel);
    }
}