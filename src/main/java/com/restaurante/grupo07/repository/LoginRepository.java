package com.restaurante.grupo07.repository;

import com.restaurante.grupo07.model.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface LoginRepository extends JpaRepository<Login, String> {

    Login findByUsername(@Param("username") String username);
    boolean existsByUsername(@Param("username") String username);
}
