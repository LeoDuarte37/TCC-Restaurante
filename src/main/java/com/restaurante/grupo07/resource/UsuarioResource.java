package com.restaurante.grupo07.resource;

import com.restaurante.grupo07.model.Usuario;
import com.restaurante.grupo07.dto.UsuarioDto;
import com.restaurante.grupo07.service.UsuarioService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
@RequiredArgsConstructor
public class UsuarioResource {

    @Autowired
    private final UsuarioService usuarioService;
    @PostMapping
    @Transactional
    public ResponseEntity<Usuario> adicionar(@Valid @RequestBody UsuarioDto usuarioDto) {
        return usuarioService.adicionar(usuarioDto);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> buscarPorId(@PathVariable("id") @NotNull Long id) {
        return usuarioService.buscarPorId(id);
    }
    @GetMapping("/listar")
    public ResponseEntity<List<Usuario>> listar() {
        return usuarioService.listar();
    }
    @PutMapping
    @Transactional
    public ResponseEntity<Usuario> atualizar(@Valid @RequestBody UsuarioDto usuarioDto) {
        return usuarioService.atualizar(usuarioDto);
    }
    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable("id") @NotNull Long id) {
        usuarioService.excluir(id);
    }
}
