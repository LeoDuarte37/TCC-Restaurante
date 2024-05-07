package com.restaurante.grupo07.repository;

import com.restaurante.grupo07.enumeration.StatusPedido;
import com.restaurante.grupo07.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    public List<Pedido> findAllByStatusOrderByDataDesc(@Param("status") StatusPedido status);
    @Query(value = "select p from Pedido p inner join p.mesa m where m.numero = ?1")
    public List<Pedido> findAllByMesa(@Param("mesa") Long mesa);
}
