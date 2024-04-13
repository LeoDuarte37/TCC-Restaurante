package com.restaurante.grupo07.repository;

import com.restaurante.grupo07.model.Login;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepository extends JpaRepository<Login, Long> {
}
