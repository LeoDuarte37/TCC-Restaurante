package com.restaurante.grupo07.repository;

import com.restaurante.grupo07.model.Restaurante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

public interface RestauranteRepository extends JpaRepository<Restaurante, Long> {

}
