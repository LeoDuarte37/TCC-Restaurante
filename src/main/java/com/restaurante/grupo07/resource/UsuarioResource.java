package com.restaurante.grupo07.resource;

import com.restaurante.grupo07.model.Perfil;
import com.restaurante.grupo07.model.Usuario;
import com.restaurante.grupo07.resource.dto.PerfilDto;
import com.restaurante.grupo07.resource.dto.UsuarioDto;
import com.restaurante.grupo07.service.PerfilService;
import com.restaurante.grupo07.service.UsuarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
@RequiredArgsConstructor
public class UsuarioResource {

    private final UsuarioService usuarioService;
    @PostMapping
    public ResponseEntity<Usuario> adicionarUsuario(@Valid @RequestBody UsuarioDto usuarioDto) {
        return usuarioService.adicionarUsuario(usuarioDto);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> buscarUsuarioPorId(@PathVariable("id") Long id) {
        return usuarioService.buscarUsuarioPorId(id);
    }
    @GetMapping("/listar")
    public ResponseEntity<List<Usuario>> listarUsuarios() {
        return usuarioService.listarUsuarios();
    }
    @PutMapping("/{id}")
    public ResponseEntity<Usuario> atualizarUsuario(@PathVariable("id") Long id, @Valid @RequestBody UsuarioDto usuarioDto) {
        return usuarioService.atualizarUsuario(id, usuarioDto);
    }
    @DeleteMapping("/{id}")
    public void excluirUsuario(@PathVariable("id") Long id) {
        usuarioService.excluirUsuario(id);
    }
}
