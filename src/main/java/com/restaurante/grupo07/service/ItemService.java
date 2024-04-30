package com.restaurante.grupo07.service;

import java.util.List;

import com.restaurante.grupo07.dto.ItemDto;

public interface ItemService {
    ItemDto adicionar(ItemDto itemDto);
    ItemDto buscarPorId(Long id);
    List<ItemDto> listar();
    List<ItemDto> listarPorPedido(Long id);
    ItemDto atualizar(ItemDto itemDto);
    void excluir(Long id);
}
