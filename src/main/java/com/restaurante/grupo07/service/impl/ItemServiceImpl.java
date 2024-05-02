package com.restaurante.grupo07.service.impl;

import com.restaurante.grupo07.dto.ItemDto;
import com.restaurante.grupo07.dto.mapper.ItemMapper;
import com.restaurante.grupo07.model.Item;
import com.restaurante.grupo07.repository.ItemRepository;
import com.restaurante.grupo07.repository.PedidoRepository;
import com.restaurante.grupo07.repository.ProdutoRepository;
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
    private final ProdutoRepository produtoRepository;

    @Autowired
    private final PedidoRepository pedidoRepository;

    @Autowired
    private final ItemMapper itemMapper;

    @Override
    public ItemDto adicionar(ItemDto itemDto) {
        if (produtoRepository.existsById(itemDto.produto().getId())) {
            if (pedidoRepository.existsById(itemDto.pedido().getId())) {
                return itemMapper.toDto(itemRepository.save(itemMapper.toEntity(itemDto)));
            }

            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Pedido nao encontrado!");
        }

        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Produto nao encontrado!");
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
        if (produtoRepository.existsById(itemDto.produto().getId())) {
            return itemRepository.findById(itemDto.id())
                    .map(entity -> {
                        entity.setProduto(itemDto.produto());
                        entity.setQuantidade(itemDto.quantidade());
                        entity.setObservacao(itemDto.observacao());
                        entity.setPedido(itemDto.pedido());
                        return itemMapper.toDto(itemRepository.save(entity));

                    }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Item não encontrado!"));
        }

        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Produto nao encontrado!");
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
