package es.marcosar.ejercicio5.service;

import es.marcosar.ejercicio5.dto.CrearReservaDTO;
import es.marcosar.ejercicio5.model.Cliente;
import es.marcosar.ejercicio5.model.Habitacion;
import es.marcosar.ejercicio5.model.Reserva;
import es.marcosar.ejercicio5.repository.ClienteRepository;
import es.marcosar.ejercicio5.repository.HabitacionRepository;
import es.marcosar.ejercicio5.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.StreamSupport;

@Service
public class ReservaService {
    @Autowired
    private ReservaRepository reservaRepository;
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private HabitacionRepository habitacionRepository;

    public List<Reserva> findAll() {
        return StreamSupport.stream(reservaRepository.findAll().spliterator(), false).toList();
    }

    public List<Reserva> findAllByClienteId(Long id) {
        return reservaRepository.findByCliente_Id(id);
    }

    public Reserva crearReserva(Long cliente_id, Long habitacion_id, CrearReservaDTO dto) {
        Cliente cliente = clienteRepository.findById(cliente_id).orElseThrow();

        Habitacion habitacion = habitacionRepository.findById(habitacion_id).orElseThrow();

        Reserva reserva = new Reserva(
                cliente,
                habitacion,
                dto.getFecha_checkin(),
                dto.getFecha_checkout()
        );

        return reservaRepository.save(reserva);
    }

    public Reserva add(Reserva reserva) {
        return reservaRepository.save(reserva);
    }

    public Reserva update(Long id, Reserva reserva) {
        Optional<Reserva> opt = reservaRepository.findById(id);

        if (opt.isEmpty()) {
            throw new NoSuchElementException("No existe el cliente con id " + id);
        }

        Reserva r = opt.get();

        r.setCliente(reserva.getCliente());
        r.setHabitacion(reserva.getHabitacion());
        r.setFecha_checkin(reserva.getFecha_checkin());
        r.setFecha_checkout(reserva.getFecha_checkout());

        return reservaRepository.save(r);
    }

    public void delete(Long id) {
        Reserva r = reservaRepository.findById(id).orElseThrow();
        reservaRepository.delete(r);
    }
}
