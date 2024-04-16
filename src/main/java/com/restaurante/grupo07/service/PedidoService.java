package com.restaurante.grupo07.service;

import com.restaurante.grupo07.model.Item;
import com.restaurante.grupo07.model.Pedido;
import com.restaurante.grupo07.resource.dto.ItemDto;

import java.util.List;

public interface PedidoService {
    List<Item> listarItens(Long id);
    Item adicionarItem(ItemDto itemDto);
    void excluirItem(Long id);
    Pedido atualizarStatus(Long id, String status);

}
