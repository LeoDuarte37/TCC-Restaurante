package com.restaurante.grupo07.service.impl;

import com.restaurante.grupo07.dto.ItemDto;
import com.restaurante.grupo07.dto.mapper.ItemMapper;
import com.restaurante.grupo07.repository.ItemRepository;
import com.restaurante.grupo07.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {

    @Autowired
    private final ItemRepository itemRepository;

    @Autowired
    private final ItemMapper itemMapper;

    @Override
    public ItemDto adicionar(ItemDto itemDto) {
        return null;
    }

    @Override
    public ItemDto buscarPorId(Long id) {
        return null;
    }

    @Override
    public List<ItemDto> listar() {
        return null;
    }

    @Override
    public List<ItemDto> listarPorPedido(Long id) {
        return null;
    }

    @Override
    public ItemDto atualizar(ItemDto itemDto) {
        return null;
    }

    @Override
    public void excluir(Long id) {

    }
}
