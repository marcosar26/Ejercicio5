package es.marcosar.ejercicio5.service;

import es.marcosar.ejercicio5.dto.CrearReservaDTO;
import es.marcosar.ejercicio5.dto.ReservaDto;
import es.marcosar.ejercicio5.model.Cliente;
import es.marcosar.ejercicio5.model.Habitacion;
import es.marcosar.ejercicio5.model.Reserva;
import es.marcosar.ejercicio5.repository.ClienteRepository;
import es.marcosar.ejercicio5.repository.HabitacionRepository;
import es.marcosar.ejercicio5.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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

    private ReservaDto mapToDto(Reserva reserva) {
        return new ReservaDto(
                reserva.getId(),
                reserva.getCliente().getId(),
                reserva.getHabitacion().getId(),
                reserva.getFecha_checkin(),
                reserva.getFecha_checkout()
        );
    }

    public List<ReservaDto> findAll() {
        return StreamSupport.stream(reservaRepository.findAll().spliterator(), false).map(this::mapToDto).toList();
    }

    public List<ReservaDto> findAllByClienteId(Long id) {
        return reservaRepository.findByCliente_Id(id).stream().map(this::mapToDto).toList();
    }

    public ReservaDto crearReserva(Long cliente_id, Long habitacion_id, CrearReservaDTO dto) {
        Cliente cliente = clienteRepository.findById(cliente_id).orElseThrow();

        Habitacion habitacion = habitacionRepository.findById(habitacion_id).orElseThrow();

        Reserva reserva = new Reserva(
                cliente,
                habitacion,
                dto.getFecha_checkin(),
                dto.getFecha_checkout()
        );

        return mapToDto(reservaRepository.save(reserva));
    }

    public ReservaDto add(Reserva reserva) {
        return mapToDto(reservaRepository.save(reserva));
    }

    public ReservaDto actualizarReserva(
            Long reserva_id,
            LocalDateTime fecha_checkin,
            LocalDateTime fecha_checkout) {
        Reserva reserva = reservaRepository.findById(reserva_id).orElseThrow();

        reserva.setFecha_checkin(fecha_checkin);
        reserva.setFecha_checkout(fecha_checkout);

        return mapToDto(reservaRepository.save(reserva));
    }

    public ReservaDto update(Long id, Reserva reserva) {
        Optional<Reserva> opt = reservaRepository.findById(id);

        if (opt.isEmpty()) {
            throw new NoSuchElementException("No existe el cliente con id " + id);
        }

        Reserva r = opt.get();

        r.setCliente(reserva.getCliente());
        r.setHabitacion(reserva.getHabitacion());
        r.setFecha_checkin(reserva.getFecha_checkin());
        r.setFecha_checkout(reserva.getFecha_checkout());

        return mapToDto(reservaRepository.save(r));
    }

    public void delete(Long id) {
        Reserva r = reservaRepository.findById(id).orElseThrow();
        reservaRepository.delete(r);
    }

    public void deleteByClienteId(Long clienteId) {
        reservaRepository.deleteAll(reservaRepository.findByCliente_Id(clienteId));
    }

    public void deleteByClienteIdAndHabitacionId(Long clienteId, Long habitacionId) {
        reservaRepository.deleteAll(reservaRepository.findByCliente_IdAndHabitacion_Id(clienteId, habitacionId));
    }
}
