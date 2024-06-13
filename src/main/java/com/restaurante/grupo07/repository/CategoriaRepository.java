package com.restaurante.grupo07.repository;

import com.restaurante.grupo07.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    @Query(value = "select * from Categoria c where c.restaurante.id = :restaurante and c.disponivel = true")
    public List<Categoria> findAllByRestauranteDisponivelTrue(@Param("restaurante") Long restaurante);

    public List<Categoria> findAllByRestaurante(@Param("restaurante") Long restaurante);

    public List<Categoria> findAllByNomeContainingIgnoreCase(@Param("nome") String nome);
}
