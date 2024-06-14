package com.restaurante.grupo07.repository;

import com.restaurante.grupo07.enumeration.StatusMesa;
import com.restaurante.grupo07.model.Mesa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface MesaRepository extends JpaRepository<Mesa, Long> {

    @Query(value = "select m from Mesa m where m.restaurante.id = :restaurante and m.status = :status order by m.numero")
    public List<Mesa> findAllByRestauranteAndStatus(@Param("restaurante") Long restaurante, @Param("status") StatusMesa status);

    @Query(value = "select m from Mesa m where m.restaurante.id = :restaurante order by m.numero")
    public List<Mesa> findAllByRestauranteOrderByNumero(@Param("restaurante") Long restaurante);

    @Query(value = "select m from Mesa m where m.restaurante.id = :restaurante and m.chamarGarcom = true order by m.numero")
    public List<Mesa> findAllByChamarGarcomTrue(@Param("restaurante") Long restaurante);

    @Query(value = "SELECT * FROM tb_mesa m WHERE m.numero = ?2 AND EXISTS (SELECT 1 FROM tb_restaurante r WHERE r.uuid = ?1)", nativeQuery = true)
    public Mesa findByRestaurante(@Param("uuid") UUID uuid, @Param("numero") Long numero);
}