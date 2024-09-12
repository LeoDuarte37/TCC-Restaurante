package com.restaurante.grupo07.api;

import com.restaurante.grupo07.api.request.AtualizarCardapioDto;
import com.restaurante.grupo07.api.request.AddSubcategoriaDto;
import com.restaurante.grupo07.api.response.SubcategoriaDto;
import com.restaurante.grupo07.business.SubcategoriaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/subcategoria")
public class SubcategoriaResource {

    @Autowired
    private SubcategoriaService subcategoriaService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Transactional
    public SubcategoriaDto adicionar(@Valid @RequestBody AddSubcategoriaDto addSubcategoriaDto) {
        return subcategoriaService.adicionar(addSubcategoriaDto);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    @Transactional
    public SubcategoriaDto atualizar(@Valid @RequestBody AtualizarCardapioDto atualizarCardapioDto) {
        return subcategoriaService.atualizar(atualizarCardapioDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Transactional
    public void excluir(@PathVariable("id") Long id) {
        subcategoriaService.excluir(id);
    }
}
