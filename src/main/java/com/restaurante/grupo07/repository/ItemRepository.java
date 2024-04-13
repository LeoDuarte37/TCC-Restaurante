package com.restaurante.grupo07.repository;

import com.restaurante.grupo07.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
