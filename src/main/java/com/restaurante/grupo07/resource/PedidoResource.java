package com.restaurante.grupo07.resource;

import com.restaurante.grupo07.model.Pedido;
import com.restaurante.grupo07.dto.PedidoDto;
import com.restaurante.grupo07.service.PedidoService;

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
@RequestMapping("/pedido")
@RequiredArgsConstructor
public class PedidoResource {

    @Autowired
    private final PedidoService pedidoService;
    @PostMapping
    @Transactional
    public ResponseEntity<Pedido> adicionar(@Valid @RequestBody PedidoDto pedidoDto) {
        return pedidoService.adicionar(pedidoDto);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Pedido> buscarPorId(@PathVariable("id") @NotNull Long id) {
        return pedidoService.buscarPorId(id);
    }
    @GetMapping("/listar")
    public ResponseEntity<List<Pedido>> listar() {
        return pedidoService.listar();
    }
    @GetMapping("/listar/mesa/{mesa}")
    public ResponseEntity<List<Object[]>> listarPorMesa(@PathVariable("mesa") @NotNull Long mesa) {
        return pedidoService.listarPorMesa(mesa);
    }
    @GetMapping("/listar/status/{status}")
    public ResponseEntity<List<Pedido>> listarPorStatus(@PathVariable("status") @NotBlank String status) {
        return pedidoService.listarPorStatus(status);
    }
    @PutMapping
    @Transactional
    public ResponseEntity<Pedido> atualizar(@Valid @RequestBody PedidoDto pedidoDto) {
        return pedidoService.atualizar(pedidoDto);
    }
    @PatchMapping("/{id}/atualizarStatus")
    @Transactional
    public ResponseEntity<Pedido> atualizarStatus(@PathVariable("id") @NotNull Long id, @RequestBody @NotBlank String status) {
        return pedidoService.atualizarStatus(id, status);
    }
    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable("id") @NotNull Long id) {
        pedidoService.excluir(id);
    }
}
