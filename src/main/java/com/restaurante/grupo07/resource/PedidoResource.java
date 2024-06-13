package com.restaurante.grupo07.resource;

import com.restaurante.grupo07.dto.FecharContaDto;
import com.restaurante.grupo07.dto.ListarPorStatusDto;
import com.restaurante.grupo07.dto.ListarPedidosPorMesaDto;
import com.restaurante.grupo07.dto.PedidoDto;
import com.restaurante.grupo07.enumeration.StatusPedido;
import com.restaurante.grupo07.service.PedidoService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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
    public List<PedidoDto> listarPorMesaInStatus(@Valid @RequestBody ListarPedidosPorMesaDto listarPedidosPorMesaDto) {
        return pedidoService.listarPorMesaInStatus(listarPedidosPorMesaDto);
    }

    @GetMapping("/listar/status")
    @ResponseStatus(HttpStatus.OK)
    public List<PedidoDto> listarPorStatus(@Valid @RequestBody ListarPorStatusDto listarPorStatusDto) {
        return pedidoService.listarPorStatus(listarPorStatusDto);
    }

    @GetMapping("/listar/restaurante/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<PedidoDto> listarPorRestaurante(@PathVariable("id") @NotNull Long id) {
        return pedidoService.listarPorRestaurante(id);
    }

    @GetMapping("/listar/dataAtual/restaurante/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<PedidoDto> listarPorRestauranteDataAtual(@PathVariable("id") @NotNull Long id) {
        return pedidoService.listarPorRestauranteDataAtual(id);
    }

    @PutMapping("/fecharConta")
    @ResponseStatus(HttpStatus.ACCEPTED)
    @Transactional
    public void fecharConta(@Valid @RequestBody FecharContaDto fecharContaDto) {
        pedidoService.fecharConta(fecharContaDto);
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
