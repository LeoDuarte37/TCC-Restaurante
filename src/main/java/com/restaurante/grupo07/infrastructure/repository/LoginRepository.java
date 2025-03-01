package com.restaurante.grupo07.infrastructure.repository;

import com.restaurante.grupo07.infrastructure.model.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends JpaRepository<Login, String> {

    Login findByUsername(@Param("username") String username);
    boolean existsByUsername(@Param("username") String username);
}
