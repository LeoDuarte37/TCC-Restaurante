package com.restaurante.grupo07.service.impl;

import com.restaurante.grupo07.dto.SubcategoriaDto;
import com.restaurante.grupo07.dto.mapper.SubcategoriaMapper;
import com.restaurante.grupo07.model.Subcategoria;
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
    private SubcategoriaRepository subcategoriaRepository;

    @Autowired
    private SubcategoriaMapper subcategoriaMapper;

    @Override
    public SubcategoriaDto adicionar(SubcategoriaDto subcategoriaDto) {
        return subcategoriaMapper.toDto(subcategoriaRepository.save(subcategoriaMapper.toEntity(subcategoriaDto)));
    }

    @Override
    public SubcategoriaDto atualizar(SubcategoriaDto subcategoriaDto) {
        return subcategoriaRepository.findById(subcategoriaDto.id())
                .map(entity -> {
                    entity.setNome(subcategoriaDto.nome());
                    entity.setDisponivel(subcategoriaDto.disponivel());
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
