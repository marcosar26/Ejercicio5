package es.marcosar.ejercicio5.repository;

import es.marcosar.ejercicio5.model.Habitacion;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HabitacionRepository extends CrudRepository<Habitacion, Long> {
    List<Habitacion> findByDisponible(Boolean disponible);
}