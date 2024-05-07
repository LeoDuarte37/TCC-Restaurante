package com.restaurante.grupo07.resource;

import com.restaurante.grupo07.dto.UsuarioDto;
import com.restaurante.grupo07.service.UsuarioService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
@RequiredArgsConstructor
public class UsuarioResource {

    @Autowired
    private final UsuarioService usuarioService;

    @PostMapping("/cliente")
    @Transactional
    public UsuarioDto adicionar(@Valid @RequestBody UsuarioDto usuarioDto) {
        return usuarioService.adicionar(usuarioDto);
    }

    @GetMapping("/{id}")
    public UsuarioDto buscarPorId(@PathVariable("id") @NotNull Long id) {
        return usuarioService.buscarPorId(id);
    }

    @GetMapping("/listar")
    public List<UsuarioDto> listar() {
        return usuarioService.listar();
    }

    @PutMapping
    @Transactional
    public UsuarioDto atualizar(@Valid @RequestBody UsuarioDto usuarioDto) {
        return usuarioService.atualizar(usuarioDto);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable("id") @NotNull Long id) {
        usuarioService.excluir(id);
    }
}
