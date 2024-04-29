package com.restaurante.grupo07.resource;

import com.restaurante.grupo07.model.Mesa;
import com.restaurante.grupo07.dto.MesaDto;
import com.restaurante.grupo07.service.MesaService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mesa")
@RequiredArgsConstructor
public class MesaResource {

    @Autowired
    private final MesaService mesaService;
    @PostMapping
    @Transactional
    public ResponseEntity<Mesa> adicionar(@Valid @RequestBody MesaDto mesaDto) {
        return mesaService.adicionar(mesaDto);
    }
    @GetMapping("/{numero}")
    public ResponseEntity<Mesa> buscarPorNumero(@PathVariable("numero") @NotNull Long numero) {
        return mesaService.buscarPorNumero(numero);
    }
    @GetMapping("/listar")
    public ResponseEntity<List<Mesa>> listar() {
        return mesaService.listar();
    }
    @GetMapping("/listar/status/{status}")
    public ResponseEntity<List<Mesa>> listarPorStatus(@PathVariable("status") @NotBlank String status) {
        return mesaService.listarPorStatus(status);
    }
    @GetMapping("/listar/chamandoGarcom")
    public ResponseEntity<List<Mesa>> listarChamandoGarcom() {
        return mesaService.listarChamandoGarcom();
    }
    @PutMapping
    @Transactional
    public ResponseEntity<Mesa> atualizar(@Valid @RequestBody MesaDto mesaDto) {
        return mesaService.atualizar(mesaDto);
    }
    @PatchMapping("/{numero}/atualizarStatus")
    @Transactional
    public ResponseEntity<Mesa> atualizarStatus(@PathVariable("numero") @NotNull Long numero, @RequestBody @NotBlank String status) {
        return mesaService.atualizarStatus(numero, status);
    }
    @PatchMapping("/{numero}/atualizarChamarGarcom")
    @Transactional
    public ResponseEntity<Mesa> atualizarChamarGarcom(@PathVariable("numero") @NotNull Long numero, @RequestBody @NotNull boolean chamarGarcom) {
        return mesaService.atualizarChamarGarcom(numero, chamarGarcom);
    }
    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable("id") @NotNull Long id) {
        mesaService.excluir(id);
    }
}
