package com.restaurante.grupo07.repository;

import com.restaurante.grupo07.model.Contato;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContatoRepository extends JpaRepository<Contato, Long> {

}
