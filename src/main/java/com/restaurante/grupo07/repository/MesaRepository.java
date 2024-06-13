package com.restaurante.grupo07.repository;

import com.restaurante.grupo07.enumeration.StatusMesa;
import com.restaurante.grupo07.model.Mesa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface MesaRepository extends JpaRepository<Mesa, Long> {

    @Query(value = "select * from Mesa m where m.restaurante.id = :restaurante and m.status = :status order by m.numero")
    public List<Mesa> findAllByStatusOrderByNumero(@Param("restaurante") Long restaurante, @Param("status") StatusMesa status);

    public List<Mesa> findAllByRestauranteOrderByNumero(@Param("restaurante") Long restaurante);

    @Query(value = "select * from Mesa m where m.restaurante.id = :restaurante and m.chamarGarcom = true order by m.numero")
    public List<Mesa> findAllByChamarGarcomTrue(@Param("restaurante") Long restaurante);
}