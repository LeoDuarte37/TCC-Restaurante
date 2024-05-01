package com.restaurante.grupo07.service.impl;

import com.restaurante.grupo07.dto.ContatoDto;
import com.restaurante.grupo07.dto.mapper.ContatoMapper;
import com.restaurante.grupo07.repository.ContatoRepository;
import com.restaurante.grupo07.service.ContatoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContatoServiceImpl implements ContatoService {

    @Autowired
    private final ContatoRepository contatoRepository;

    @Autowired
    private final ContatoMapper contatoMapper;

    @Override
    public ContatoDto adicionar(ContatoDto contatoDto) {
        return contatoMapper.toDto(contatoRepository.save(contatoMapper.toEntity(contatoDto)));
    }

    @Override
    public ContatoDto buscarPorId(Long id) {
        return categoriaRepository.findById(id)
                .map(entity -> contatoMapper.toDto(entity))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public List<ContatoDto> listar() {
        return categoriaRepository.findAll()
                .stream()
                .map(entity -> contatoMapper.toDto(entity))
                .collect(Collectors.toList());
    }

    @Override
    public ContatoDto atualizar(ContatoDto contatoDto) {
        return contatoRepository.findById(contatoDto.id())
                .map(entity -> {
                    entity.setEmail(contatoDto.email());
                    entity.setTelefone(contatoDto.telefone());
                    return contatoMapper.toDto(entity);
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public void excluir(Long id) {
        Optional<Contato> contato = contatoRepository.findById(id);

        if(contato.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        contatoRepository.deleteById(id);
    }
}
