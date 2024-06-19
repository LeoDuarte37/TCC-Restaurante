package com.restaurante.grupo07.repository;

import com.restaurante.grupo07.model.Categoria;
import com.restaurante.grupo07.model.Subcategoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubcategoriaRepository extends JpaRepository<Subcategoria, Long> {

    public List<Subcategoria> findByDisponivelTrueAndCategoria(@Param("categoria") Categoria categoria);
}
