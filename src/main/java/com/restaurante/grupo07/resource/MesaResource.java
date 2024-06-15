package com.restaurante.grupo07.resource;

import com.restaurante.grupo07.dto.StatusDto;
import com.restaurante.grupo07.dto.mesa.AddMesaDto;
import com.restaurante.grupo07.dto.mesa.AtualizarMesaDto;
import com.restaurante.grupo07.dto.mesa.LoginMesaDto;
import com.restaurante.grupo07.dto.mesa.MesaDto;
import com.restaurante.grupo07.service.MesaService;
import jakarta.validation.Valid;
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
    public MesaDto adicionar(@Valid @RequestBody AddMesaDto addMesaDto) {
        return mesaService.adicionar(addMesaDto);
    }

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public MesaDto loginMesa(@Valid @RequestBody LoginMesaDto loginMesaDto) {
        return mesaService.loginMesa(loginMesaDto);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public MesaDto buscarPorId(@PathVariable("id") @NotNull Long id) {
        return mesaService.buscarPorId(id);
    }

    @GetMapping("/listar/restaurante/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<MesaDto> listarPorRestaurante(@PathVariable("id") @NotNull Long restauranteId) {
        return mesaService.listarPorRestaurante(restauranteId);
    }

    @GetMapping("/listar/status")
    @ResponseStatus(HttpStatus.OK)
    public List<MesaDto> listarPorRestauranteAndStatus(@Valid @RequestBody StatusDto statusDto) {
        return mesaService.listarPorRestauranteAndStatus(statusDto);
    }

    @GetMapping("/listar/chamandoGarcom/restaurante/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<MesaDto> listarChamandoGarcom(@PathVariable("id") @NotNull Long restauranteId) {
        return mesaService.listarChamandoGarcom(restauranteId);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    @Transactional
    public MesaDto atualizar(@Valid @RequestBody AtualizarMesaDto atualizarMesaDto) {
        return mesaService.atualizar(atualizarMesaDto);
    }

    @PatchMapping("/atualizar/status")
    @ResponseStatus(HttpStatus.ACCEPTED)
    @Transactional
    public MesaDto atualizarStatus(@Valid @RequestBody StatusDto statusDto) {
        return mesaService.atualizarStatus(statusDto);
    }

    @PatchMapping("/atualizar/chamarGarcom/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    @Transactional
    public MesaDto atualizarChamarGarcom(@PathVariable("id") @NotNull Long id) {
        return mesaService.atualizarChamarGarcom(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Transactional
    public void excluir(@PathVariable("id") @NotNull Long id) {
        mesaService.excluir(id);
    }
}
