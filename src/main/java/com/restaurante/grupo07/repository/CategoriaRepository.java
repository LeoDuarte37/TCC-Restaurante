package com.restaurante.grupo07.repository;

import com.restaurante.grupo07.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    @Query(value = "SELECT * FROM tb_categoria c WHERE c.disponivel = true AND EXISTS (SELECT 1 FROM tb_restaurante r WHERE r.id = ?1)",
            nativeQuery = true)
    public List<Categoria> findAllByRestauranteAndDisponivelTrue(@Param("restaurante") Long restaurante);

    @Query(value = "SELECT * FROM tb_categoria c "
            + "LEFT JOIN tb_subcategoria sc ON sc.categoria_id = c.id "
            + "LEFT JOIN tb_produto p ON p.subcategoria_id = sc.id "
            + "WHERE c.disponivel = true AND sc.disponivel = true AND p.disponivel = true "
            + "AND EXISTS (SELECT 1 FROM tb_restaurante r WHERE r.id = ?1)",
            nativeQuery = true)
    List<Object[]> findAllCategoriaSubcategoriaProdutoDisponiveis(@Param("restaurante") Long restaurante);

    @Query(value = "select c from Categoria c where c.restaurante.id = :restaurante")
    public List<Categoria> findAllByRestaurante(@Param("restaurante") Long restaurante);

    public List<Categoria> findAllByNomeContainingIgnoreCase(@Param("nome") String nome);
}
