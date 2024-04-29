package com.restaurante.grupo07.service.impl;

import com.restaurante.grupo07.dto.CategoriaDto;
import com.restaurante.grupo07.dto.mapper.CategoriaMapper;
import com.restaurante.grupo07.model.Categoria;
import com.restaurante.grupo07.repository.CategoriaRepository;
import com.restaurante.grupo07.service.CategoriaService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    private final CategoriaRepository categoriaRepository;

    @Autowired
    private final CategoriaMapper categoriaMapper;
    @Override
    public CategoriaDto adicionar(com.restaurante.grupo07.dto.CategoriaDto categoriaDto) {
        Categoria categoria = categoriaMapper.toEntity(categoriaDto);
        //return categoriaRepository.save(categoria);
    }

    @Override
    public CategoriaDto buscarPorId(Long id) {
        return null;
    }

    @Override
    public List<CategoriaDto> buscarPorNome(String nome) {
        //return categoriaRepository.findAllByNomeContainingIgnoreCase(nome);
    }

    @Override
    public List<CategoriaDto> listar() {
        //return categoriaRepository.findAll();
    }

    @Override
    public List<CategoriaDto> listarDisponiveis() {
        //return categoriaRepository.findByDisponivelTrue();
    }

    @Override
    public CategoriaDto atualizar(CategoriaDto categoriaDto) {

        return categoriaRepository.findById(categoriaDto.id())
                .map(entity -> {
                    entity.setNome(categoriaDto.nome());
                    entity.setFoto(categoriaDto.foto());
                    entity.setDisponivel(categoriaDto.disponivel());
                    return categoriaMapper.toDto(categoriaRepository.save(entity));

                }).orElseThrow(() -> new EntityNotFoundException());

    }

    @Override
    public CategoriaDto atualizarStatus(Long id, boolean disponivel) {
        return null;
    }

    @Override
    public void excluir(Long id) {

    }
}
