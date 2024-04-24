package com.restaurante.grupo07.repository;

import com.restaurante.grupo07.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    public List<Pedido> findAllByStatusStartingWithOrderByDataDesc(@Param("status") String status);
    public List<Pedido> findAllByMesa(@Param("mesa") Long mesa);
}
