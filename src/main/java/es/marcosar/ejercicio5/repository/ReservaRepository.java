package es.marcosar.ejercicio5.repository;

import es.marcosar.ejercicio5.model.Reserva;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservaRepository extends CrudRepository<Reserva, Long> {
}