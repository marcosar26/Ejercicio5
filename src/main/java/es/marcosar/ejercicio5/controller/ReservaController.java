package es.marcosar.ejercicio5.controller;

import es.marcosar.ejercicio5.dto.CrearReservaDTO;
import es.marcosar.ejercicio5.dto.ReservaDto;
import es.marcosar.ejercicio5.model.Reserva;
import es.marcosar.ejercicio5.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/reservas")
public class ReservaController {
    @Autowired
    private ReservaService reservaService;

    @GetMapping
    public ResponseEntity<List<ReservaDto>> findAll() {
        List<ReservaDto> reservas = reservaService.findAll();
        return reservas.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(reservas);
    }

    @GetMapping("/cliente")
    public ResponseEntity<List<ReservaDto>> findAllByClienteId(Long id) {
        List<ReservaDto> reservas = reservaService.findAllByClienteId(id);
        return reservas.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(reservas);
    }

    @PutMapping("/crear")
    public ResponseEntity<ReservaDto> crear(@RequestParam Long cliente_id,
                                            @RequestParam Long habitacion_id,
                                            @RequestBody CrearReservaDTO dto) {
        ReservaDto reserva = reservaService.crearReserva(cliente_id, habitacion_id, dto);
        return reserva == null ? ResponseEntity.badRequest().build() : ResponseEntity.ok(reserva);
    }

    @PutMapping
    public ResponseEntity<ReservaDto> add(@RequestBody Reserva reserva) {
        ReservaDto r = reservaService.add(reserva);
        return r == null ? ResponseEntity.badRequest().build() : ResponseEntity.ok(r);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<ReservaDto> actualizarReserva(
            @PathVariable("id") Long reserva_id,
            @RequestParam(value = "fecha_checkin", required = false) LocalDateTime fecha_checkin,
            @RequestParam(value = "fecha_checkout", required = false) LocalDateTime fecha_checkout
    ) {
        ReservaDto reserva = reservaService.actualizarReserva(reserva_id, fecha_checkin, fecha_checkout);
        return reserva == null ? ResponseEntity.badRequest().build() : ResponseEntity.ok(reserva);
    }

    @PatchMapping
    public ResponseEntity<ReservaDto> update(@RequestParam Long id, @RequestBody Reserva reserva) {
        ReservaDto r = reservaService.update(id, reserva);
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

    @DeleteMapping("/eliminar/cliente")
    public ResponseEntity<Void> eliminarReservaClienteId(@RequestParam Long cliente_id) {
        try {
            reservaService.deleteByClienteId(cliente_id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/eliminar/cliente_habitacion")
    public ResponseEntity<Void> eliminarReservasClienteHabitacion(
            @RequestParam Long cliente_id,
            @RequestParam Long habitacion_id
    ) {
        try {
            reservaService.deleteByClienteIdAndHabitacionId(cliente_id, habitacion_id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
