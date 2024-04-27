package com.restaurante.grupo07.resource;

import com.restaurante.grupo07.model.Mesa;
import com.restaurante.grupo07.resource.dto.MesaDto;
import com.restaurante.grupo07.service.MesaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mesa")
@RequiredArgsConstructor
public class MesaResource {

    private final MesaService mesaService;
    @PostMapping
    public ResponseEntity<Mesa> adicionarMesa(@Valid @RequestBody MesaDto mesaDto) {
        return mesaService.adicionarMesa(mesaDto);
    }
    @GetMapping("/{numero}")
    public ResponseEntity<Mesa> buscarMesaPorNumero(@PathVariable("numero") Long numero) {
        return mesaService.buscarMesaPorNumero(numero);
    }
    @GetMapping("/listar")
    public ResponseEntity<List<Mesa>> listarMesas() {
        return mesaService.listarMesas();
    }
    @GetMapping("/listar/status/{status}")
    public ResponseEntity<List<Mesa>> listarMesasPorStatus(@PathVariable("status") String status) {
        return mesaService.listarMesasPorStatus(status);
    }
    @GetMapping("/listar/chamandoGarcom")
    public ResponseEntity<List<Mesa>> listarChamandoGarcom() {
        return mesaService.listarChamandoGarcom();
    }
    @PutMapping("/{id}")
    public ResponseEntity<Mesa> atualizarMesa(@PathVariable("id") Long id, @Valid @RequestBody MesaDto mesaDto) {
        return mesaService.atualizarMesa(id, mesaDto);
    }
    @PatchMapping("/{id}/atualizarStatus")
    public ResponseEntity<Mesa> atualizarStatusMesa(@PathVariable("id") Long id, @RequestBody String status) {
        return mesaService.atualizarStatusMesa(id, status);
    }
    @PatchMapping("/{id}/atualizarChamarGarcom")
    public ResponseEntity<Mesa> atualizarChamarGarcom(@PathVariable("id") Long id, @RequestBody boolean chamarGarcom) {
        return mesaService.atualizarChamarGarcom(id, chamarGarcom);
    }
    @DeleteMapping("/{id}")
    public void excluirMesa(@PathVariable("id") Long id) {
        mesaService.excluirMesa(id);
    }
}
