package com.restaurante.grupo07.resource;

import com.restaurante.grupo07.dto.CategoriaDto;
import com.restaurante.grupo07.service.CategoriaService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categoria")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CategoriaResource {

    @Autowired
    private CategoriaService categoriaService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Transactional
    public CategoriaDto adicionar(@Valid @RequestBody CategoriaDto categoriaDto) {
        return categoriaService.adicionar(categoriaDto);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CategoriaDto buscarPorId(@PathVariable("id") Long id) {
        return categoriaService.buscarPorId(id);
    }


    @GetMapping("/listar")
    @ResponseStatus(HttpStatus.OK)
    public List<CategoriaDto> listar() {
        return categoriaService.listar();
    }
    
    @GetMapping("/listar/nome/{nome}")
    @ResponseStatus(HttpStatus.OK)
    public List<CategoriaDto> listarPorNome(@PathVariable("nome") String nome) {
        return categoriaService.listarPorNome(nome);
    }

    @GetMapping("/listar/disponiveis")
    @ResponseStatus(HttpStatus.OK)
    public List<CategoriaDto> listarDisponiveis() {
        return categoriaService.listarDisponiveis();
    }

    @PutMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    @Transactional
    public CategoriaDto atualizar(@Valid @RequestBody CategoriaDto categoriaDto) {
        return categoriaService.atualizar(categoriaDto);
    }

    @PatchMapping("/atualizar/status")
    @ResponseStatus(HttpStatus.ACCEPTED)
    @Transactional
    public CategoriaDto atualizarStatus(@RequestBody CategoriaDto categoriaDto) {
        return categoriaService.atualizarStatus(categoriaDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Transactional
    public void excluir(@PathVariable("id") @NotNull Long id) {
        categoriaService.excluir(id);
    }
}
