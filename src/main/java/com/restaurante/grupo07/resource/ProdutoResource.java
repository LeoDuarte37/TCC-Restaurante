package com.restaurante.grupo07.resource;

import com.restaurante.grupo07.model.Produto;
import com.restaurante.grupo07.resource.dto.ProdutoDto;
import com.restaurante.grupo07.service.ProdutoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produto")
@RequiredArgsConstructor
public class ProdutoResource {

    private final ProdutoService produtoService;

    @PostMapping
    public ResponseEntity<Produto> adicionarProduto(@Valid @RequestBody ProdutoDto produtoDto) {
        return produtoService.adicionarProduto(produtoDto);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Produto> buscarProdutoPorId(@PathVariable("id") Long id) {
        return produtoService.buscarProdutoPorId(id);
    }
    @GetMapping("/listar")
    public ResponseEntity<List<Produto>> listarProdutos() {
        return produtoService.listarProdutos();
    }
    @GetMapping("/listar/disponiveis")
    public ResponseEntity<List<Produto>> listarProdutosDisponiveis() {
        return produtoService.listarProdutosDisponiveis();
    }
    @GetMapping("/listar/nome/{nome}")
    public ResponseEntity<List<Produto>> listarProdutosPorNome(@PathVariable("nome") String nome) {
        return produtoService.listarProdutosPorNome(nome);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Produto> editarProduto(@PathVariable("id") Long id, @Valid @RequestBody ProdutoDto produtoDto) {
        return produtoService.editarProduto(id, produtoDto);
    }
    @PatchMapping("/{id}")
    public ResponseEntity<Produto> editarStatusProduto(@PathVariable Long id, @RequestBody boolean disponivel) {
        return produtoService.editarStatusProduto(id, disponivel);
    }
    @DeleteMapping("/{id}")
    public void excluirProduto(Long id) {
        produtoService.excluirProduto(id);
    }
}
