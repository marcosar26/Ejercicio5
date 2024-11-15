package es.marcosar.ejercicio5.controller;

import es.marcosar.ejercicio5.dto.ClienteDto;
import es.marcosar.ejercicio5.model.Cliente;
import es.marcosar.ejercicio5.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<ClienteDto>> findAll() {
        List<ClienteDto> clientes = clienteService.findAll();
        return clientes.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(clientes);
    }

    @PutMapping
    public ResponseEntity<ClienteDto> add(@RequestBody Cliente cliente) {
        ClienteDto c = clienteService.add(cliente);
        return c == null ? ResponseEntity.badRequest().build() : ResponseEntity.ok(c);
    }

    @PatchMapping
    public ResponseEntity<ClienteDto> update(@RequestParam Long id, @RequestBody Cliente cliente) {
        ClienteDto c = clienteService.update(id, cliente);
        return c == null ? ResponseEntity.badRequest().build() : ResponseEntity.ok(c);
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@RequestParam Long id) {
        try {
            clienteService.delete(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
