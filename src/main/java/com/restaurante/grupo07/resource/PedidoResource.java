package com.restaurante.grupo07.resource;

import com.restaurante.grupo07.model.Pedido;
import com.restaurante.grupo07.resource.dto.PedidoDto;
import com.restaurante.grupo07.service.PedidoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedido")
@RequiredArgsConstructor
public class PedidoResource {

    private final PedidoService pedidoService;
    @PostMapping
    public ResponseEntity<Pedido> adicionarPedido(@Valid @RequestBody PedidoDto pedidoDto) {
        return pedidoService.adicionarPedido(pedidoDto);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Pedido> buscarPedidoPorId(@PathVariable("id") Long id) {
        return pedidoService.buscarPedidoPorId(id);
    }
    @GetMapping("/listar")
    public ResponseEntity<List<Pedido>> listarPedidos() {
        return pedidoService.listarPedidos();
    }
    @GetMapping("/listar/mesa/{mesa}")
    public ResponseEntity<List<Object[]>> listarPedidosPorMesa(@PathVariable("mesa") Long mesa) {
        return pedidoService.listarPedidosPorMesa(mesa);
    }
    @GetMapping("/listar/status/{status}")
    public ResponseEntity<List<Pedido>> listarPedidosPorStatus(@PathVariable("status") String status) {
        return pedidoService.listarPedidosPorStatus(status);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Pedido> atualizarPedido(@PathVariable("id") Long id, @Valid @RequestBody PedidoDto pedidoDto) {
        return pedidoService.atualizarPedido(id, pedidoDto);
    }
    @PatchMapping("/atualizarStatus/{id}")
    public ResponseEntity<Pedido> atualizarStatusPedido(@PathVariable("id") Long id, @RequestBody String status) {
        return pedidoService.atualizarStatusPedido(id, status);
    }
    @DeleteMapping("/{id}")
    public void excluirPedido(@PathVariable("id") Long id) {
        pedidoService.excluirPedido(id);
    }
}
