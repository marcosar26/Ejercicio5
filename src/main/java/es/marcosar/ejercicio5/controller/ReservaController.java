package es.marcosar.ejercicio5.controller;

import es.marcosar.ejercicio5.dto.CrearReservaDTO;
import es.marcosar.ejercicio5.model.Reserva;
import es.marcosar.ejercicio5.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservas")
public class ReservaController {
    @Autowired
    private ReservaService reservaService;

    @GetMapping
    public ResponseEntity<List<Reserva>> findAll() {
        List<Reserva> reservas = reservaService.findAll();
        return reservas.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(reservas);
    }

    @GetMapping("/cliente")
    public ResponseEntity<List<Reserva>> findAllByClienteId(Long id) {
        List<Reserva> reservas = reservaService.findAllByClienteId(id);
        return reservas.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(reservas);
    }

    @PutMapping("/crear")
    public ResponseEntity<Reserva> crear(@RequestParam Long cliente_id,
                                         @RequestParam Long habitacion_id,
                                         @RequestBody CrearReservaDTO dto) {
        Reserva reserva = reservaService.crearReserva(cliente_id, habitacion_id, dto);
        return reserva == null ? ResponseEntity.badRequest().build() : ResponseEntity.ok(reserva);
    }

    @PutMapping
    public ResponseEntity<Reserva> add(@RequestBody Reserva reserva) {
        Reserva r = reservaService.add(reserva);
        return r == null ? ResponseEntity.badRequest().build() : ResponseEntity.ok(r);
    }

    @PatchMapping
    public ResponseEntity<Reserva> update(@RequestParam Long id, @RequestBody Reserva reserva) {
        Reserva r = reservaService.update(id, reserva);
        return r == null ? ResponseEntity.badRequest().build() : ResponseEntity.ok(r);
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@RequestParam Long id) {
        try {
            reservaService.delete(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
