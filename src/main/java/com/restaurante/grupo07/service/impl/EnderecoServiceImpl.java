package com.restaurante.grupo07.service.impl;

import com.restaurante.grupo07.dto.mapper.EnderecoMapper;
import com.restaurante.grupo07.model.Endereco;
import com.restaurante.grupo07.repository.EnderecoRepository;
import com.restaurante.grupo07.dto.EnderecoDto;
import com.restaurante.grupo07.service.EnderecoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EnderecoServiceImpl implements EnderecoService {

    @Autowired
    private final EnderecoRepository enderecoRepository;

    @Autowired
    private final EnderecoMapper enderecoMapper;

    @Override
    public EnderecoDto adicionar(EnderecoDto enderecoDto) {
        return enderecoMapper.toDto(enderecoRepository.save(enderecoMapper.toEntity(enderecoDto)));
    }

    @Override
    public EnderecoDto buscarPorId(Long id) {
        return enderecoRepository.findById(id)
                .map(entity -> enderecoMapper.toDto(entity))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public List<EnderecoDto> listar() {
        return enderecoRepository.findAll()
                .stream()
                .map(entity -> enderecoMapper.toDto(entity))
                .collect(Collectors.toList());
    }

    @Override
    public EnderecoDto atualizar(EnderecoDto enderecoDto) {
        return enderecoRepository.findById(enderecoDto.id())
                .map(entity -> {
                    entity.setRua(enderecoDto.rua());
                    entity.setBairro(enderecoDto.bairro());
                    entity.setCidade(enderecoDto.cidade());
                    entity.setUf(enderecoDto.uf());
                    return enderecoMapper.toDto(entity);

                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public void excluir(Long id) {
        Optional<Endereco> endereco = enderecoRepository.findById(id);

        if (endereco.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        enderecoRepository.deleteById(id);
    }
}
