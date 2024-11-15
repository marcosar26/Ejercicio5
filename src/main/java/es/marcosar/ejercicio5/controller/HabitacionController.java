package es.marcosar.ejercicio5.controller;

import es.marcosar.ejercicio5.dto.HabitacionDto;
import es.marcosar.ejercicio5.model.Habitacion;
import es.marcosar.ejercicio5.service.HabitacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/habitaciones")
public class HabitacionController {
    @Autowired
    private HabitacionService habitacionService;

    @GetMapping
    public ResponseEntity<List<HabitacionDto>> findAll() {
        List<HabitacionDto> habitaciones = habitacionService.findAll();
        return habitaciones.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(habitaciones);
    }

    @GetMapping("/disponibles")
    public ResponseEntity<List<HabitacionDto>> findDisponibles() {
        List<HabitacionDto> habitacionesDisp = habitacionService.findAllDisponibles();
        return habitacionesDisp.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(habitacionesDisp);
    }

    @PutMapping
    public ResponseEntity<HabitacionDto> add(@RequestBody Habitacion habitacion) {
        HabitacionDto h = habitacionService.add(habitacion);
        return h == null ? ResponseEntity.badRequest().build() : ResponseEntity.ok(h);
    }

    @PatchMapping
    public ResponseEntity<HabitacionDto> update(@RequestParam Long id, @RequestBody Habitacion habitacion) {
        HabitacionDto h = habitacionService.update(id, habitacion);
        return h == null ? ResponseEntity.badRequest().build() : ResponseEntity.ok(h);
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@RequestParam Long id) {
        try {
            habitacionService.delete(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
