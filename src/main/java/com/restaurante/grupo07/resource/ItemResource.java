package com.restaurante.grupo07.resource;

import com.restaurante.grupo07.model.Item;
import com.restaurante.grupo07.dto.ItemDto;
import com.restaurante.grupo07.service.ItemService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/item")
@RequiredArgsConstructor
public class ItemResource {

    @Autowired
    private final ItemService itemService;
    @PostMapping
    @Transactional
    public ResponseEntity<Item> adicionar(@Valid @RequestBody ItemDto itemDto) {
        return itemService.adicionar(itemDto);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Item> buscarPorId(@PathVariable("id") @NotNull Long id) {
        return itemService.buscarPorId(id);
    }
    @GetMapping("/listar")
    public ResponseEntity<List<Item>> listar() {
        return itemService.listar();
    }
    @GetMapping("/listar/pedido/{id}")
    public ResponseEntity<List<Item>> listarPorPedido(@PathVariable("id") @NotNull Long id) {
        return itemService.listarPorPedido(id);
    }
    @PutMapping
    @Transactional
    public ResponseEntity<Item> atualizar(@Valid @RequestBody ItemDto itemDto) {
        return itemService.atualizar(itemDto);
    }
    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable("id") @NotNull Long id) {
        itemService.excluir(id);
    }
}
