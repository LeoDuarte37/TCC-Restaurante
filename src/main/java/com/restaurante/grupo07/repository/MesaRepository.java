package com.restaurante.grupo07.repository;

import com.restaurante.grupo07.enumeration.StatusMesa;
import com.restaurante.grupo07.model.Mesa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MesaRepository extends JpaRepository<Mesa, Long> {

    public List<Mesa> findAllByStatusOrderByNumero(@Param("status") StatusMesa status);

    public List<Mesa> findAllByChamarGarcomTrue();
}