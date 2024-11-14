package es.marcosar.ejercicio5.service;

import es.marcosar.ejercicio5.model.Habitacion;
import es.marcosar.ejercicio5.repository.HabitacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.StreamSupport;

@Service
public class HabitacionService {
    @Autowired
    private HabitacionRepository habitacionRepository;

    public List<Habitacion> findAll() {
        return StreamSupport.stream(habitacionRepository.findAll().spliterator(), false).toList();
    }

    public Habitacion add(Habitacion habitacion) {
        return habitacionRepository.save(habitacion);
    }

    public Habitacion update(Long id, Habitacion habitacion) {
        Optional<Habitacion> opt = habitacionRepository.findById(id);

        if (opt.isEmpty()) {
            throw new NoSuchElementException("No existe el cliente con id " + id);
        }

        Habitacion h = opt.get();

        h.setNumero(habitacion.getNumero());
        h.setTipo(habitacion.getTipo());
        h.setCapacidad(habitacion.getCapacidad());
        h.setPrecio(habitacion.getPrecio());
        h.setDisponible(habitacion.getDisponible());
        h.setReservas(habitacion.getReservas());

        return habitacionRepository.save(h);
    }

    public void delete(Long id) {
        Optional<Habitacion> opt = habitacionRepository.findById(id);

        if (opt.isEmpty()) {
            throw new NoSuchElementException("No existe el cliente con id " + id);
        }

        habitacionRepository.deleteById(id);
    }
}
