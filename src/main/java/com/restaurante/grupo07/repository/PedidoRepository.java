package com.restaurante.grupo07.repository;

import com.restaurante.grupo07.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
