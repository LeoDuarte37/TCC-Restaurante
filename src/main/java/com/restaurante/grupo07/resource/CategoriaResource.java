package com.restaurante.grupo07.resource;

import com.restaurante.grupo07.dto.AtualizarCardapioDto;
import com.restaurante.grupo07.dto.categoria.AddCategoriaDto;
import com.restaurante.grupo07.dto.categoria.CategoriaDto;
import com.restaurante.grupo07.service.CategoriaService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
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
    public CategoriaDto adicionar(@Valid @RequestBody AddCategoriaDto addCategoriaDto) {
        return categoriaService.adicionar(addCategoriaDto);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CategoriaDto buscarPorId(@PathVariable("id") @NotNull Long id) {
        return categoriaService.buscarPorId(id);
    }
    
    @GetMapping("/listar/nome/{nome}")
    @ResponseStatus(HttpStatus.OK)
    public List<CategoriaDto> listarPorNome(@PathVariable("nome") @NotBlank String nome) {
        return categoriaService.listarPorNome(nome);
    }

    @GetMapping("/listar/restaurante/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<CategoriaDto> listarPorRestaurante(@PathVariable("id") @NotNull Long id) {
        return categoriaService.listarPorRestaurante(id);
    }

    @GetMapping("/listar/disponiveis/restaurante/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<CategoriaDto> listarDisponiveisPorRestaurante(@PathVariable("id") @NotNull Long id) {
        return categoriaService.listarDisponiveisPorRestaurante(id);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    @Transactional
    public CategoriaDto atualizar(@Valid @RequestBody AtualizarCardapioDto atualizarCardapioDto) {
        return categoriaService.atualizar(atualizarCardapioDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Transactional
    public void excluir(@PathVariable("id") @NotNull Long id) {
        categoriaService.excluir(id);
    }
}
