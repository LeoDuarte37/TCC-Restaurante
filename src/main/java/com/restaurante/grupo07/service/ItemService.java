package com.restaurante.grupo07.service;

import java.util.List;

import com.restaurante.grupo07.model.Item;
import com.restaurante.grupo07.resource.dto.ItemDto;
import org.springframework.http.ResponseEntity;

public interface ItemService {
    ResponseEntity<Item> adicionarItem(ItemDto itemDto);
    ResponseEntity<Item> buscarItemPorId(Long id);
    ResponseEntity<List<Item>> listarItens();
    ResponseEntity<List<Item>> listarItensPorPedido(Long id);
    ResponseEntity<Item> atualizarItem(Long id, ItemDto itemDto);
    void excluirItem(Long id);
}
