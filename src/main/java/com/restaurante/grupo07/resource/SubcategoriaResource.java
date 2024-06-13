package com.restaurante.grupo07.resource;

import com.restaurante.grupo07.dto.SubcategoriaDto;
import com.restaurante.grupo07.service.SubcategoriaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/subcategoria")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class SubcategoriaResource {

    @Autowired
    private SubcategoriaService subcategoriaService;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    @Transactional
    public SubcategoriaDto adicionar(@Valid @RequestBody SubcategoriaDto subcategoriaDto) {
        return subcategoriaService.adicionar(subcategoriaDto);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    @Transactional
    public SubcategoriaDto atualizar(@Valid @RequestBody SubcategoriaDto subcategoriaDto) {
        return subcategoriaService.atualizar(subcategoriaDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Transactional
    public void deletar(@PathVariable("id") Long id) {
        subcategoriaService.excluir(id);
    }
}
