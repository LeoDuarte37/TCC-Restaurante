package com.restaurante.grupo07.repository;

import com.restaurante.grupo07.model.Restaurante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestauranteRepository extends JpaRepository<Restaurante, Long> {
}
