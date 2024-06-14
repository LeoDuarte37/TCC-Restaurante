package com.restaurante.grupo07.repository;

import com.restaurante.grupo07.model.Restaurante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RestauranteRepository extends JpaRepository<Restaurante, Long> {
    @Query(value = "select r from Restaurante r where r.uuid = :uuid")
    public Restaurante findRestauranteByUuid(@Param("uuid") UUID uuid);
}
