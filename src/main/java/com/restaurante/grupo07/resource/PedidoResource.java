package com.restaurante.grupo07.resource;

import com.restaurante.grupo07.dto.ListarMesaPorStatusDto;
import com.restaurante.grupo07.dto.ListarPedidosPorMesaDto;
import com.restaurante.grupo07.dto.PedidoDto;
import com.restaurante.grupo07.service.PedidoService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedido")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PedidoResource {

    @Autowired
    private PedidoService pedidoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Transactional
    public PedidoDto adicionar(@Valid @RequestBody PedidoDto pedidoDto) {
        return pedidoService.adicionar(pedidoDto);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PedidoDto buscarPorId(@PathVariable("id") @NotNull Long id) {
        return pedidoService.buscarPorId(id);
    }

    @GetMapping("/listar")
    @ResponseStatus(HttpStatus.OK)
    public List<PedidoDto> listar() {
        return pedidoService.listar();
    }

    @GetMapping("/listar/mesa")
    @ResponseStatus(HttpStatus.OK)
    public List<PedidoDto> listarPorMesa(@Valid @RequestBody ListarPedidosPorMesaDto listarPedidosPorMesaDto) {
        return pedidoService.listarPorMesa(listarPedidosPorMesaDto);
    }

    @GetMapping("/listar/status")
    @ResponseStatus(HttpStatus.OK)
    public List<PedidoDto> listarPorStatus(@Valid @RequestBody ListarMesaPorStatusDto listarMesaPorStatusDto) {
        return pedidoService.listarPorStatus(listarMesaPorStatusDto);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    @Transactional
    public PedidoDto atualizar(@Valid @RequestBody PedidoDto pedidoDto) {
        return pedidoService.atualizar(pedidoDto);
    }

    @PatchMapping("/atualizar/status")
    @ResponseStatus(HttpStatus.ACCEPTED)
    @Transactional
    public PedidoDto atualizarStatus(@RequestBody PedidoDto pedidoDto) {
        return pedidoService.atualizarStatus(pedidoDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Transactional
    public void excluir(@PathVariable("id") @NotNull Long id) {
        pedidoService.excluir(id);
    }
}
