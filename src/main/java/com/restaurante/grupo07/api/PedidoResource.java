package com.restaurante.grupo07.api;

import com.restaurante.grupo07.api.request.StatusDto;
import com.restaurante.grupo07.api.request.AddPedidoDto;
import com.restaurante.grupo07.api.request.AtualizarPedidoDto;
import com.restaurante.grupo07.api.request.ListarPedidosPorMesaAndStatusDto;
import com.restaurante.grupo07.api.response.PedidoDto;
import com.restaurante.grupo07.business.PedidoService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedido")
public class PedidoResource {

    @Autowired
    private PedidoService pedidoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Transactional
    public PedidoDto adicionar(@Valid @RequestBody AddPedidoDto addPedidoDto) {
        return pedidoService.adicionar(addPedidoDto);
    }

    @PostMapping("/listar/mesa")
    @ResponseStatus(HttpStatus.OK)
    public List<PedidoDto> listarPorMesaInStatus(@Valid @RequestBody ListarPedidosPorMesaAndStatusDto listarPedidosPorMesaAndStatusDto) {
        return pedidoService.listarPorMesaInStatus(listarPedidosPorMesaAndStatusDto);
    }

    @PostMapping("/listar/status")
    @ResponseStatus(HttpStatus.OK)
    public List<PedidoDto> listarPorStatus(@Valid @RequestBody StatusDto statusDto) {
        return pedidoService.listarPorStatus(statusDto);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PedidoDto buscarPorId(@PathVariable("id") @NotNull Long id) {
        return pedidoService.buscarPorId(id);
    }

    @GetMapping("/listar/restaurante/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<PedidoDto> listarPorRestaurante(@PathVariable("id") @NotNull Long id) {
        return pedidoService.listarPorRestaurante(id);
    }

    @GetMapping("/listar/data/corrente/restaurante/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<PedidoDto> listarPorRestauranteDataAtual(@PathVariable("id") @NotNull Long id) {
        return pedidoService.listarPorRestauranteDataAtual(id);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    @Transactional
    public PedidoDto atualizar(@Valid @RequestBody AtualizarPedidoDto atualizarPedidoDto) {
        return pedidoService.atualizar(atualizarPedidoDto);
    }

    @PutMapping("/fecharConta/mesa/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    @Transactional
    public void fecharConta(@PathVariable("id") @NotNull Long id) {
        pedidoService.fecharConta(id);
    }

    @PatchMapping("/atualizar/status")
    @ResponseStatus(HttpStatus.ACCEPTED)
    @Transactional
    public PedidoDto atualizarStatus(@Valid @RequestBody StatusDto statusDto) {
        return pedidoService.atualizarStatus(statusDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Transactional
    public void excluir(@PathVariable("id") @NotNull Long id) {
        pedidoService.excluir(id);
    }
}
