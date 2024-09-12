package com.restaurante.grupo07.infrastructure.repository;

import com.restaurante.grupo07.infrastructure.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> { }
