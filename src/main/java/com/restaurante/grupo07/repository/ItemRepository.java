package com.restaurante.grupo07.repository;

import com.restaurante.grupo07.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {
    @Query(value = "select i.id, i.produto, i.quantidade, i.observacao, i.pedido from Item i inner join i.pedido p where p.id = ?1")
    public List<Item> findAllByPedido(@Param("pedido") Long id);
}
