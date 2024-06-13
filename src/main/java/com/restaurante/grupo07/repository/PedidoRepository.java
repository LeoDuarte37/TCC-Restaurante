package com.restaurante.grupo07.repository;

import com.restaurante.grupo07.enumeration.StatusPedido;
import com.restaurante.grupo07.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Set;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    @Query(value = "select * from Pedido p inner join Mesa m where m.restaurante.id = ?1 and p.status = ?2 order by p.data desc")
    public List<Pedido> findAllByStatusOrderByDataDesc(@Param("restaurante") Long restaurante, @Param("status") StatusPedido status);

    @Query(value = "select * from Pedido p inner join Mesa m where m.restaurante.id = ?1 and p.data = CURRENT_DATE order by p.data desc")
    public List<Pedido> findAllByRestauranteCurrenteDate(@Param("restaurante") Long restaurante);

    @Query(value = "select * from Pedido p inner join Mesa m where m.restaurante.id = ?1 order by p.data desc")
    public List<Pedido> findAllByRestaurante(@Param("restaurante") Long restaurante);

    @Query(value = "select * from Pedido p where p.mesa.id = :mesa and p.status in :statusPedidos")
    public List<Pedido> findAllByMesaInStatus(@Param("mesa") Long mesa, @Param("statusPedidos") Set<StatusPedido> statusPedidos);

    @Query(value = "update Pedido p set p.status = :statusUpdate where p.mesa.id = :mesa and p.status in :statusReference")
    public void fecharConta(@Param("mesa") Long mesa, @Param("statusUpdate") StatusPedido statusUpdate, @Param("statusReference") Set<StatusPedido> statusReference);
}
