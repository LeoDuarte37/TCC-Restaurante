package com.restaurante.grupo07.resource;

import com.restaurante.grupo07.model.Endereco;
import com.restaurante.grupo07.resource.dto.EnderecoDto;
import com.restaurante.grupo07.service.EnderecoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/endereco")
@RequiredArgsConstructor
public class EnderecoResource {

    private final EnderecoService enderecoService;
    @PostMapping
    public ResponseEntity<Endereco> adicionarEndereco(@Valid @RequestBody EnderecoDto enderecoDto) {
        return enderecoService.adicionarEndereco(enderecoDto);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Endereco> buscarEnderecoPorId(@PathVariable("id") Long id) {
        return enderecoService.buscarEnderecoPorId(id);
    }
    @GetMapping("/listar")
    public ResponseEntity<List<Endereco>> listarEnderecos() {
        return enderecoService.listarEnderecos();
    }
    @PutMapping("/{id}")
    public ResponseEntity<Endereco> atualizarEndereco(@PathVariable("id") Long id, @Valid @RequestBody EnderecoDto enderecoDto) {
        return enderecoService.atualizarEndereco(id, enderecoDto);
    }
    @DeleteMapping("/{id}")
    public void excluirEndereco(@PathVariable("id") Long id) {
        enderecoService.excluirPedido(id);
    }
}
