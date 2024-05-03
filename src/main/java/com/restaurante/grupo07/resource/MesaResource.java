package com.restaurante.grupo07.resource;

import com.restaurante.grupo07.dto.MesaDto;
import com.restaurante.grupo07.service.MesaService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    @ResponseStatus(HttpStatus.CREATED)
    @Transactional
    public MesaDto adicionar(@Valid @RequestBody MesaDto mesaDto) {
        return mesaService.adicionar(mesaDto);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public MesaDto buscarPorNumero(@PathVariable("id") @NotNull Long id) {
        return mesaService.buscarPorId(id);
    }

    @GetMapping("/listar")
    @ResponseStatus(HttpStatus.OK)
    public List<MesaDto> listar() {
        return mesaService.listar();
    }

    @GetMapping("/listar/status/{status}")
    @ResponseStatus(HttpStatus.OK)
    public List<MesaDto> listarPorStatus(@PathVariable("status") @NotBlank String status) {
        return mesaService.listarPorStatus(status);
    }

    @GetMapping("/listar/chamandoGarcom")
    @ResponseStatus(HttpStatus.OK)
    public List<MesaDto> listarChamandoGarcom() {
        return mesaService.listarChamandoGarcom();
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    @Transactional
    public MesaDto atualizar(@Valid @RequestBody MesaDto mesaDto) {
        return mesaService.atualizar(mesaDto);
    }

    @PatchMapping("/{id}/atualizarStatus")
    @ResponseStatus(HttpStatus.OK)
    @Transactional
    public MesaDto atualizarStatus(@PathVariable("id") @NotNull Long id, @RequestBody @NotBlank String status) {
        return mesaService.atualizarStatus(id, status);
    }

    @PatchMapping("/{id}/atualizarChamarGarcom")
    @ResponseStatus(HttpStatus.OK)
    @Transactional
    public MesaDto atualizarChamarGarcom(@PathVariable("id") @NotNull Long id, @RequestBody String chamarGarcom) {
        return mesaService.atualizarChamarGarcom(id, chamarGarcom);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Transactional
    public void excluir(@PathVariable("id") @NotNull Long id) {
        mesaService.excluir(id);
    }
}
