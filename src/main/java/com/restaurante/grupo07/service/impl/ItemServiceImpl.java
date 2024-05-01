package com.restaurante.grupo07.service.impl;

import com.restaurante.grupo07.dto.ItemDto;
import com.restaurante.grupo07.dto.mapper.ItemMapper;
import com.restaurante.grupo07.model.Item;
import com.restaurante.grupo07.repository.ItemRepository;
import com.restaurante.grupo07.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {

    @Autowired
    private final ItemRepository itemRepository;

    @Autowired
    private final ItemMapper itemMapper;

    @Override
    public ItemDto adicionar(ItemDto itemDto) {
        return itemMapper.toDto(itemRepository.save(itemMapper.toEntity(itemDto)));
    }

    @Override
    public ItemDto buscarPorId(Long id) {
        return itemRepository.findById(id)
                .map(entity -> itemMapper.toDto(entity))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public List<ItemDto> listar() {
        return itemRepository.findAll()
                .stream()
                .map(entity -> itemMapper.toDto(entity))
                .collect(Collectors.toList());
    }

    @Override
    public List<ItemDto> listarPorPedido(Long id) {
        return itemRepository.findAllByPedido(id)
                .stream()
                .map(entity -> itemMapper.toDto(entity))
                .collect(Collectors.toList());
    }

    @Override
    public ItemDto atualizar(ItemDto itemDto) {
        return itemRepository.findById(itemDto.id())
                .map(entity -> itemMapper.toDto(entity))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public void excluir(Long id) {
        Optional<Item> item = itemRepository.findById(id);

        if (item.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        itemRepository.deleteById(id);
    }
}
