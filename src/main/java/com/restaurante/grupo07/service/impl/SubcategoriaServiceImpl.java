package com.restaurante.grupo07.service.impl;

import com.restaurante.grupo07.dto.AtualizarCardapioDto;
import com.restaurante.grupo07.dto.subcategoria.AddSubcategoriaDto;
import com.restaurante.grupo07.dto.subcategoria.SubcategoriaDto;
import com.restaurante.grupo07.mapper.SubcategoriaMapper;
import com.restaurante.grupo07.model.Categoria;
import com.restaurante.grupo07.model.Subcategoria;
import com.restaurante.grupo07.repository.CategoriaRepository;
import com.restaurante.grupo07.repository.SubcategoriaRepository;
import com.restaurante.grupo07.service.SubcategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class SubcategoriaServiceImpl implements SubcategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private SubcategoriaRepository subcategoriaRepository;

    @Autowired
    private SubcategoriaMapper subcategoriaMapper;

    @Override
    public void adicionar(AddSubcategoriaDto addSubcategoriaDto) {
        Optional<Categoria> categoria = categoriaRepository.findById(addSubcategoriaDto.categoriaId());

        if (categoria.isPresent()) {
            Subcategoria subcategoria = new Subcategoria(
                    addSubcategoriaDto.nome(),
                    addSubcategoriaDto.disponivel(),
                    categoria.get()
            );
            subcategoriaRepository.save(subcategoria);
        }

        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Categoria não encontrada!");
    }

    @Override
    public SubcategoriaDto atualizar(AtualizarCardapioDto atualizarCardapioDto) {
        return subcategoriaRepository.findById(atualizarCardapioDto.id())
                .map(entity -> {
                    entity.setNome(atualizarCardapioDto.nome());
                    entity.setDisponivel(atualizarCardapioDto.disponivel());
                    return subcategoriaMapper.toDto(subcategoriaRepository.save(entity));
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Subcategoria não encontrada"));
    }

    @Override
    public void excluir(Long id) {
        Optional<Subcategoria> subcategoria = subcategoriaRepository.findById(id);

        if (subcategoria.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Subcategoria não encontrada");
        }

        subcategoriaRepository.deleteById(id);
    }
}
