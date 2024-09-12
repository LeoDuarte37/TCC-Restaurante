package com.restaurante.grupo07.api;

import com.restaurante.grupo07.api.request.UsuarioDto;
import com.restaurante.grupo07.business.UsuarioService;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioResource {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UsuarioDto buscarPorId(@PathVariable("id") @NotNull Long id) {
        return usuarioService.buscarPorId(id);
    }

    @GetMapping("/listar")
    @ResponseStatus(HttpStatus.OK)
    public List<UsuarioDto> listar() {
        return usuarioService.listar();
    }
}
