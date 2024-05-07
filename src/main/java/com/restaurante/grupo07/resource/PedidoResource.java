package com.restaurante.grupo07.resource;

import com.restaurante.grupo07.dto.PedidoDto;
import com.restaurante.grupo07.service.PedidoService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedido")
@RequiredArgsConstructor
public class PedidoResource {

    @Autowired
    private final PedidoService pedidoService;

    @PostMapping
    @Transactional
    public PedidoDto adicionar(@Valid @RequestBody PedidoDto pedidoDto) {
        return pedidoService.adicionar(pedidoDto);
    }

    @GetMapping("/{id}")
    public PedidoDto buscarPorId(@PathVariable("id") @NotNull Long id) {
        return pedidoService.buscarPorId(id);
    }

    @GetMapping("/listar")
    public List<PedidoDto> listar() {
        return pedidoService.listar();
    }

    @GetMapping("/listar/mesa/{mesa}")
    public List<PedidoDto> listarPorMesa(@PathVariable("mesa") @NotNull Long mesa) {
        return pedidoService.listarPorMesa(mesa);
    }

    @GetMapping("/listar/status/{status}")
    public List<PedidoDto> listarPorStatus(@PathVariable("status") @NotBlank String status) {
        return pedidoService.listarPorStatus(status);
    }

    @PutMapping
    @Transactional
    public PedidoDto atualizar(@Valid @RequestBody PedidoDto pedidoDto) {
        return pedidoService.atualizar(pedidoDto);
    }

    @PatchMapping("/atualizarStatus")
    @Transactional
    public PedidoDto atualizarStatus(@RequestBody PedidoDto pedidoDto) {
        return pedidoService.atualizarStatus(pedidoDto);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable("id") @NotNull Long id) {
        pedidoService.excluir(id);
    }
}
