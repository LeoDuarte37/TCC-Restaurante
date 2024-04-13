package com.restaurante.grupo07.repository;

import com.restaurante.grupo07.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
