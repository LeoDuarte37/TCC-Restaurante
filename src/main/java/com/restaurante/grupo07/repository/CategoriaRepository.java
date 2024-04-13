package com.restaurante.grupo07.repository;

import com.restaurante.grupo07.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
