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
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UsuarioResource {

    @Autowired
    private UsuarioService usuarioService;

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
}
