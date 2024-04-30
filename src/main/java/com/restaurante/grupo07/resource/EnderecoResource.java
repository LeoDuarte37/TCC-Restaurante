package com.restaurante.grupo07.resource;

import com.restaurante.grupo07.dto.EnderecoDto;
import com.restaurante.grupo07.service.EnderecoService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/endereco")
@RequiredArgsConstructor
public class EnderecoResource {

    @Autowired
    private final EnderecoService enderecoService;

    @PostMapping
    @Transactional
    public EnderecoDto adicionar(@Valid @RequestBody EnderecoDto enderecoDto) {
        return enderecoService.adicionar(enderecoDto);
    }

    @GetMapping("/{id}")
    public EnderecoDto buscarPorId(@PathVariable("id") @NotNull Long id) {
        return enderecoService.buscarPorId(id);
    }

    @GetMapping("/listar")
    public List<EnderecoDto> listar() {
        return enderecoService.listar();
    }

    @PutMapping
    @Transactional
    public EnderecoDto atualizar(@Valid @RequestBody EnderecoDto enderecoDto) {
        return enderecoService.atualizar(enderecoDto);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable("id") @NotNull Long id) {
        enderecoService.excluir(id);
    }
}
