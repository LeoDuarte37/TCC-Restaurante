package com.restaurante.grupo07.service;

import java.util.List;

import com.restaurante.grupo07.model.Item;
import com.restaurante.grupo07.dto.ItemDto;
import org.springframework.http.ResponseEntity;

public interface ItemService {
    ResponseEntity<Item> adicionar(ItemDto itemDto);
    ResponseEntity<Item> buscarPorId(Long id);
    ResponseEntity<List<Item>> listar();
    ResponseEntity<List<Item>> listarPorPedido(Long id);
    ResponseEntity<Item> atualizar(ItemDto itemDto);
    void excluir(Long id);
}
