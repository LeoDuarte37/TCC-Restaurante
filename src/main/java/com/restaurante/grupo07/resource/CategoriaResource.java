package com.restaurante.grupo07.resource;

import com.restaurante.grupo07.model.Categoria;
import com.restaurante.grupo07.dto.CategoriaDto;
import com.restaurante.grupo07.service.CategoriaService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categoria")
@RequiredArgsConstructor
public class CategoriaResource {

    @Autowired
    private final CategoriaService categoriaService;
    @PostMapping
    @Transactional
    public ResponseEntity<Categoria> adicionar(@Valid @RequestBody CategoriaDto categoriaDto) {
        return categoriaService.adicionar(categoriaDto);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Categoria> buscarPorId(@PathVariable("id") @NotNull Long id) {
        return categoriaService.buscarPorId(id);
    }
    @GetMapping("/{nome}")
    public ResponseEntity<List<Categoria>> buscarPorNome(@PathVariable("nome") @NotBlank String nome) {
        return categoriaService.buscarPorNome(nome);
    }
    @GetMapping("/listar")
    public ResponseEntity<List<Categoria>> listar() {
        return categoriaService.listar();
    }
    @GetMapping("/listar/disponiveis")
    public ResponseEntity<List<Categoria>> listarDisponiveis() {
        return categoriaService.listarDisponiveis();
    }
    @PutMapping
    @Transactional
    public ResponseEntity<Categoria> atualizar(@Valid @RequestBody CategoriaDto categoriaDto) {
        return categoriaService.atualizar(categoriaDto);
    }
    @PatchMapping("/{id}")
    @Transactional
    public ResponseEntity<Categoria> atualizarStatus(@PathVariable("id") @NotNull Long id, @RequestBody @NotNull boolean disponivel) {
        return categoriaService.atualizarStatus(id, disponivel);
    }
    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable("id") @NotNull Long id) {
        categoriaService.excluir(id);
    }
}
