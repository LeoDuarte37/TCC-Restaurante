package com.restaurante.grupo07.repository;

import com.restaurante.grupo07.enumeration.StatusPedido;
import com.restaurante.grupo07.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Set;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    @Query(value = "select p from Pedido p inner join p.restaurante r where r.id = ?1 and p.status = ?2 and p.data = CURRENT_DATE order by p.data desc")
    public List<Pedido> findAllByStatusOrderByDataDesc(@Param("restaurante") Long restaurante, @Param("status") StatusPedido status);

    @Query(value = "select p from Pedido p inner join p.mesa m where m.numero = :mesa in :statusPedidos")
    public List<Pedido> findAllByMesa(@Param("mesa") Long mesa, @Param("statusPedidos") Set<StatusPedido> statusPedidos);
}
