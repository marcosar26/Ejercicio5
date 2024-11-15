package es.marcosar.ejercicio5.service;

import es.marcosar.ejercicio5.dto.HabitacionDto;
import es.marcosar.ejercicio5.model.Habitacion;
import es.marcosar.ejercicio5.repository.HabitacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.StreamSupport;

@Service
public class HabitacionService {
    @Autowired
    private HabitacionRepository habitacionRepository;

    private HabitacionDto mapToDto(Habitacion habitacion) {
        return new HabitacionDto(habitacion.getNumero(), habitacion.getTipo(), habitacion.getPrecio());
    }

    public List<HabitacionDto> findAll() {
        return StreamSupport.stream(habitacionRepository.findAll().spliterator(), false)
                .map(this::mapToDto)
                .toList();
    }

    public List<HabitacionDto> findAllDisponibles() {
        return habitacionRepository.findByDisponible(true).stream().map(this::mapToDto).toList();
    }

    public HabitacionDto add(Habitacion habitacion) {
        return mapToDto(habitacionRepository.save(habitacion));
    }

    public HabitacionDto update(Long id, Habitacion habitacion) {
        Habitacion h = habitacionRepository.findById(id).orElseThrow();

        h.setNumero(habitacion.getNumero());
        h.setTipo(habitacion.getTipo());
        h.setCapacidad(habitacion.getCapacidad());
        h.setPrecio(habitacion.getPrecio());
        h.setDisponible(habitacion.getDisponible());
        h.setReservas(habitacion.getReservas());

        return mapToDto(habitacionRepository.save(h));
    }

    public void delete(Long id) {
        Habitacion h = habitacionRepository.findById(id).orElseThrow();
        habitacionRepository.delete(h);
    }
}
