package com.restaurante.grupo07.service;

import java.util.List;

import com.restaurante.grupo07.model.Item;
import com.restaurante.grupo07.resource.dto.ItemDto;

public interface ItemService {
    Item adicionarItem(ItemDto itemDto);
    Item buscarItemPorId(Long id);
    List<Item> listarItens();
    Item atualizarItem(Long id, ItemDto itemDto);
    void excluirItem(Long id);
}
