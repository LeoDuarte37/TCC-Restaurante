package com.restaurante.grupo07.repository;

import com.restaurante.grupo07.enumeration.StatusPedido;
import com.restaurante.grupo07.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    @Query(value = "select p from Pedido p cross join Mesa m where m.restaurante.id = ?1 and p.status = ?2 order by p.data desc")
    public List<Pedido> findAllByStatusOrderByDataDesc(@Param("restaurante") Long restaurante, @Param("status") StatusPedido status);

    @Query(value = "SELECT * FROM tb_pedido p WHERE DATE(p.data) = CURDATE() AND EXISTS " +
            "(SELECT 1 FROM tb_restaurante r WHERE r.id = ?1) ORDER BY p.data DESC",
        nativeQuery = true)
    public List<Pedido> findAllByRestauranteCurrenteDate(@Param("restaurante") Long restaurante);

    @Query(value = "select p from Pedido p cross join Mesa m where m.restaurante.id = ?1 order by p.data desc")
    public List<Pedido> findAllByRestaurante(@Param("restaurante") Long restaurante);

    @Query(value = "select p from Pedido p where p.mesa.id = :mesa and p.status in :statusPedidos order by p.data desc")
    public List<Pedido> findAllByMesaInStatus(@Param("mesa") Long mesa, @Param("statusPedidos") List<StatusPedido> statusPedidos);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM tb_pedido p WHERE p.id IN (SELECT pi.pedido_id FROM tb_pedido_item pi WHERE pi.produto_id = :id)",
            nativeQuery = true)
    public void deleteAllByProduto(@Param("id") Long id);
}
