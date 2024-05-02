package com.restaurante.grupo07.resource;

import com.restaurante.grupo07.model.Produto;
import com.restaurante.grupo07.dto.ProdutoDto;
import com.restaurante.grupo07.service.ProdutoService;
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
@RequestMapping("/produto")
@RequiredArgsConstructor
public class ProdutoResource {

    @Autowired
    private final ProdutoService produtoService;

    @PostMapping
    @Transactional
    public ProdutoDto adicionar(@Valid @RequestBody ProdutoDto produtoDto) {
        return produtoService.adicionar(produtoDto);
    }

    @GetMapping("/{id}")
    public ProdutoDto buscarPorId(@PathVariable("id") @NotNull Long id) {
        return produtoService.buscarPorId(id);
    }

    @GetMapping("/listar")
    public List<ProdutoDto> listar() {
        return produtoService.listar();
    }

    @GetMapping("/listar/nome/{nome}")
    public List<ProdutoDto> listarPorNome(@PathVariable("nome") @NotBlank String nome) {
        return produtoService.listarPorNome(nome);
    }

    @GetMapping("/listar/disponiveis")
    public List<ProdutoDto> listarDisponiveis() {
        return produtoService.listarDisponiveis();
    }

    @PutMapping
    @Transactional
    public ProdutoDto atualizar(@Valid @RequestBody ProdutoDto produtoDto) {
        return produtoService.atualizar(produtoDto);
    }

    @PatchMapping("/{id}")
    @Transactional
    public ProdutoDto atualizarStatus(@PathVariable("id") @NotNull Long id, @RequestBody @NotNull boolean disponivel) {
        return produtoService.atualizarStatus(id, disponivel);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable("id") @NotNull Long id) {
        produtoService.excluir(id);
    }
}
