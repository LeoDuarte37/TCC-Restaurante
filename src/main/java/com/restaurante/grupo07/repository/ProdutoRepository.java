package com.restaurante.grupo07.repository;

import com.restaurante.grupo07.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
