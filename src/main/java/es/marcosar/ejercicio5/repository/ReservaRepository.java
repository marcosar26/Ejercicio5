package es.marcosar.ejercicio5.repository;

import es.marcosar.ejercicio5.model.Reserva;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservaRepository extends CrudRepository<Reserva, Long> {
    List<Reserva> findByCliente_Id(Long clienteId);

    List<Reserva> findByCliente_IdAndHabitacion_Id(Long clienteId, Long habitacionId);
}