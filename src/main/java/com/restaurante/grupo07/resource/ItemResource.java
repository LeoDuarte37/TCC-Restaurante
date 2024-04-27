package com.restaurante.grupo07.resource;

import com.restaurante.grupo07.model.Item;
import com.restaurante.grupo07.resource.dto.ItemDto;
import com.restaurante.grupo07.service.ItemService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/item")
@RequiredArgsConstructor
public class ItemResource {

    private final ItemService itemService;
    @PostMapping
    public ResponseEntity<Item> adicionarItem(@Valid @RequestBody ItemDto itemDto) {
        return itemService.adicionarItem(itemDto);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Item> buscarItemPorId(@PathVariable("id") Long id) {
        return itemService.buscarItemPorId(id);
    }
    @GetMapping("/listar")
    public ResponseEntity<List<Item>> listarItens() {
        return itemService.listarItens();
    }
    @GetMapping("/listar/pedido/{id}")
    public ResponseEntity<List<Item>> listarItensPorPedido(@PathVariable("id") Long id) {
        return itemService.listarItensPorPedido(id);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Item> atualizarItem(@PathVariable("id") Long id, @Valid @RequestBody ItemDto itemDto) {
        return itemService.atualizarItem(id, itemDto);
    }
    @DeleteMapping("/{id}")
    public void excluirItem(@PathVariable("id") Long id) {
        itemService.excluirItem(id);
    }
}
