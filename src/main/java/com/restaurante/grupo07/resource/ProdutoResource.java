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
    public ResponseEntity<Produto> adicionar(@Valid @RequestBody ProdutoDto produtoDto) {
        return produtoService.adicionar(produtoDto);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Produto> buscarPorId(@PathVariable("id") @NotNull Long id) {
        return produtoService.buscarPorId(id);
    }
    @GetMapping("/listar")
    public ResponseEntity<List<Produto>> listar() {
        return produtoService.listar();
    }
    @GetMapping("/listar/disponiveis")
    public ResponseEntity<List<Produto>> listarDisponiveis() {
        return produtoService.listarDisponiveis();
    }
    @GetMapping("/listar/nome/{nome}")
    public ResponseEntity<List<Produto>> listarPorNome(@PathVariable("nome") @NotBlank String nome) {
        return produtoService.listarPorNome(nome);
    }
    @PutMapping
    @Transactional
    public ResponseEntity<Produto> atualizar(@Valid @RequestBody ProdutoDto produtoDto) {
        return produtoService.atualizar(produtoDto);
    }
    @PatchMapping("/{id}")
    @Transactional
    public ResponseEntity<Produto> atualizarStatus(@PathVariable("id") @NotNull Long id, @RequestBody @NotNull boolean disponivel) {
        return produtoService.atualizarStatus(id, disponivel);
    }
    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable("id") @NotNull Long id) {
        produtoService.excluir(id);
    }
}
