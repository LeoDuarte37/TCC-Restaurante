package com.restaurante.grupo07.service;

public interface PedidoService {
    List<Item> verItens(Long id);
    Item adicionarItem(ItemDto itemDto);
    void excluirItem(Long id);
    Pedido atualizarStatus(Long id, String status);

}
