package com.restaurante.grupo07.resource;

import com.restaurante.grupo07.model.Categoria;
import com.restaurante.grupo07.resource.dto.CategoriaDto;
import com.restaurante.grupo07.service.CategoriaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categoria")
@RequiredArgsConstructor
public class CategoriaResource {

    private final CategoriaService categoriaService;
    @PostMapping
    public ResponseEntity<Categoria> adicionarCategoria(@Valid @RequestBody CategoriaDto categoriaDto) {
        return categoriaService.adicionarCategoria(categoriaDto);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Categoria> buscarCategoriaPorId(@PathVariable("id") Long id) {
        return categoriaService.buscarCategoriaPorId(id);
    }
    @GetMapping("/{nome}")
    public ResponseEntity<List<Categoria>> buscarCategoriasPorNome(@PathVariable("nome") String nome) {
        return categoriaService.buscarCategoriasPorNome(nome);
    }
    @GetMapping("/listar")
    public ResponseEntity<List<Categoria>> listarCategorias() {
        return categoriaService.listarCategorias();
    }
    @GetMapping("/listarDisponiveis")
    public ResponseEntity<List<Categoria>> listarCategoriasDisponiveis() {
        return categoriaService.listarCategoriasDisponiveis();
    }
    @PutMapping("/{id}")
    public ResponseEntity<Categoria> atualizarCategoria(@PathVariable("id") Long id, @Valid @RequestBody CategoriaDto categoriaDto) {
        return categoriaService.editarCategoria(id, categoriaDto);
    }
    @PatchMapping("/{id}")
    public ResponseEntity<Categoria> atualizarStatusCategoria(@PathVariable("id") Long id, @Valid @RequestBody boolean disponivel) {
        return categoriaService.editarStatusCategoria(id, disponivel);
    }
    @DeleteMapping("/{id}")
    public void excluirCategoria(@PathVariable("id") Long id) {
        categoriaService.excluirCategoria(id);
    }
}
