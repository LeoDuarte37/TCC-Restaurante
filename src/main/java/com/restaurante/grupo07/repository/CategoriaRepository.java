package com.restaurante.grupo07.repository;

import com.restaurante.grupo07.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    @Query(value = "select c from Categoria c where c.restaurante.id = ?1 and c.disponivel = true")
    public List<Categoria> findAllByRestauranteAndDisponivelTrue(@Param("restaurante") Long restaurante);

    @Query(value = "select c from Categoria c where c.restaurante.id = :restaurante")
    public List<Categoria> findAllByRestaurante(@Param("restaurante") Long restaurante);

    public List<Categoria> findAllByNomeContainingIgnoreCase(@Param("nome") String nome);
}
