package com.restaurante.grupo07.infrastructure.repository;

import com.restaurante.grupo07.infrastructure.model.Produto;
import com.restaurante.grupo07.infrastructure.model.Subcategoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    public List<Produto> findAllByNomeContainingIgnoreCase(@Param("nome") String nome);

    public List<Produto> findByDisponivelTrueAndSubcategoria(@Param("subcategoria") Subcategoria subcategoria);
}
