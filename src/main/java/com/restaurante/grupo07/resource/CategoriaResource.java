package com.restaurante.grupo07.resource;

import com.restaurante.grupo07.dto.CategoriaDto;
import com.restaurante.grupo07.service.CategoriaService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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
    @ResponseStatus(HttpStatus.CREATED)
    @Transactional
    public CategoriaDto adicionar(@Valid @RequestBody CategoriaDto categoriaDto) {
        return categoriaService.adicionar(categoriaDto);
    }

    @GetMapping("/{id}")
    public CategoriaDto buscarPorId(@PathVariable("id") @NotNull Long id) {
        return categoriaService.buscarPorId(id);
    }

    @GetMapping("/{nome}")
    public List<CategoriaDto> buscarPorNome(@PathVariable("nome") @NotBlank String nome) {
        return categoriaService.buscarPorNome(nome);
    }
    
    @GetMapping("/listar")
    public List<CategoriaDto> listar() {
        return categoriaService.listar();
    }

    @GetMapping("/listar/disponiveis")
    public List<CategoriaDto> listarDisponiveis() {
        return categoriaService.listarDisponiveis();
    }

    @PutMapping
    @Transactional
    public CategoriaDto atualizar(@Valid @RequestBody CategoriaDto categoriaDto) {
        return categoriaService.atualizar(categoriaDto);
    }

    @PatchMapping("/{id}")
    @Transactional
    public CategoriaDto atualizarStatus(@PathVariable("id") @NotNull Long id, @RequestBody @NotNull boolean disponivel) {
        return categoriaService.atualizarStatus(id, disponivel);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Transactional
    public void excluir(@PathVariable("id") @NotNull Long id) {
        categoriaService.excluir(id);
    }
}
