package com.restaurante.grupo07.resource;

import com.restaurante.grupo07.dto.ListarPorStatusDto;
import com.restaurante.grupo07.dto.LoginMesaDto;
import com.restaurante.grupo07.dto.MesaDto;
import com.restaurante.grupo07.service.MesaService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mesa")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class MesaResource {

    @Autowired
    private MesaService mesaService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Transactional
    public MesaDto adicionar(@Valid @RequestBody MesaDto mesaDto) {
        return mesaService.adicionar(mesaDto);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public MesaDto buscarPorId(@PathVariable("id") @NotNull Long id) {
        return mesaService.buscarPorId(id);
    }

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public MesaDto loginMesa(@Valid @RequestBody LoginMesaDto loginMesaDto) {
        return mesaService.loginMesa(loginMesaDto);
    }

    @GetMapping("/listar")
    @ResponseStatus(HttpStatus.OK)
    public List<MesaDto> listar() {
        return mesaService.listar();
    }

    @GetMapping("/listar/restaurante/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<MesaDto> listarPorRestaurante(@PathVariable("id") @NotNull Long restauranteId) {
        return mesaService.listarPorRestaurante(restauranteId);
    }

    @GetMapping("/listar/status")
    @ResponseStatus(HttpStatus.OK)
    public List<MesaDto> listarPorRestauranteAndStatus(@Valid @RequestBody ListarPorStatusDto listarPorStatusDto) {
        return mesaService.listarPorRestauranteAndStatus(listarPorStatusDto);
    }

    @GetMapping("/listar/chamandoGarcom/restaurante/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<MesaDto> listarChamandoGarcom(@PathVariable("id") @NotNull Long restauranteId) {
        return mesaService.listarChamandoGarcom(restauranteId);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    @Transactional
    public MesaDto atualizar(@Valid @RequestBody MesaDto mesaDto) {
        return mesaService.atualizar(mesaDto);
    }

    @PatchMapping("/atualizar/status")
    @ResponseStatus(HttpStatus.ACCEPTED)
    @Transactional
    public MesaDto atualizarStatus(@RequestBody MesaDto mesaDto) {
        return mesaService.atualizarStatus(mesaDto);
    }

    @PatchMapping("/atualizar/chamarGarcom")
    @ResponseStatus(HttpStatus.ACCEPTED)
    @Transactional
    public MesaDto atualizarChamarGarcom(@RequestBody MesaDto mesaDto) {
        return mesaService.atualizarChamarGarcom(mesaDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Transactional
    public void excluir(@PathVariable("id") @NotNull Long id) {
        mesaService.excluir(id);
    }
}
