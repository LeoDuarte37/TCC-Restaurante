package com.restaurante.grupo07.resource;

import com.restaurante.grupo07.dto.produto.AddProdutoDto;
import com.restaurante.grupo07.dto.produto.ProdutoDto;
import com.restaurante.grupo07.service.ProdutoService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produto")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProdutoResource {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Transactional
    public void adicionar(@Valid @RequestBody AddProdutoDto addProdutoDto) {
        produtoService.adicionar(addProdutoDto);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProdutoDto buscarPorId(@PathVariable("id") @NotNull Long id) {
        return produtoService.buscarPorId(id);
    }

    @GetMapping("/listar/nome/{nome}")
    @ResponseStatus(HttpStatus.OK)
    public List<ProdutoDto> listarPorNome(@PathVariable("nome") @NotBlank String nome) {
        return produtoService.listarPorNome(nome);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    @Transactional
    public ProdutoDto atualizar(@Valid @RequestBody ProdutoDto produtoDto) {
        return produtoService.atualizar(produtoDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Transactional
    public void excluir(@PathVariable("id") @NotNull Long id) {
        produtoService.excluir(id);
    }
}
