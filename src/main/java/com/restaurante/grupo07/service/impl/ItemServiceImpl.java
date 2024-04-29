package com.restaurante.grupo07.service.impl;

import com.restaurante.grupo07.model.Item;
import com.restaurante.grupo07.repository.ItemRepository;
import com.restaurante.grupo07.dto.ItemDto;
import com.restaurante.grupo07.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {

    @Autowired
    private final ItemRepository itemRepository;
    @Override
    public ResponseEntity<Item> adicionar(ItemDto itemDto) {
        return null;
    }

    @Override
    public ResponseEntity<Item> buscarPorId(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<List<Item>> listar() {
        return null;
    }

    @Override
    public ResponseEntity<List<Item>> listarPorPedido(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<Item> atualizar(ItemDto itemDto) {
        return null;
    }

    @Override
    public void excluir(Long id) {

    }
}
