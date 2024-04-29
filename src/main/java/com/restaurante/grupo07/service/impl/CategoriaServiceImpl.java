package com.restaurante.grupo07.service.impl;

import com.restaurante.grupo07.model.Categoria;
import com.restaurante.grupo07.repository.CategoriaRepository;
import com.restaurante.grupo07.dto.CategoriaDto;
import com.restaurante.grupo07.service.CategoriaService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    private final CategoriaRepository categoriaRepository;
    @Override
    public ResponseEntity<Categoria> adicionar(CategoriaDto categoriaDto) {
        Categoria categoria = new Categoria(
                categoriaDto.nome(),
                categoriaDto.foto(),
                categoriaDto.disponivel()
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(categoriaRepository.save(categoria));
    }

    @Override
    public ResponseEntity<Categoria> buscarPorId(Long id) {
        return categoriaRepository.findById(id).map(resposta -> ResponseEntity.ok(resposta))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @Override
    public ResponseEntity<List<Categoria>> buscarPorNome(String nome) {
        return ResponseEntity.ok(categoriaRepository.findAllByNomeContainingIgnoreCase(nome));
    }

    @Override
    public ResponseEntity<List<Categoria>> listar() {
        return ResponseEntity.ok(categoriaRepository.findAll());
    }

    @Override
    public ResponseEntity<List<Categoria>> listarDisponiveis() {
        return ResponseEntity.ok(categoriaRepository.findByDisponivelTrue());
    }

    @Override
    public ResponseEntity<Categoria> atualizar(CategoriaDto categoriaDto) {

        return categoriaRepository.findById(categoriaDto.id())
                .map(resposta -> ResponseEntity.status(HttpStatus.CREATED)
                        .body(categoriaRepository.save(categoria)));

        // return ResponseEntity.status(HttpStatus.CREATED).body(categoriaRepository.save(categoria));

    }

    @Override
    public ResponseEntity<Categoria> atualizarStatus(Long id, boolean disponivel) {
        return null;
    }

    @Override
    public void excluir(Long id) {

    }
}
