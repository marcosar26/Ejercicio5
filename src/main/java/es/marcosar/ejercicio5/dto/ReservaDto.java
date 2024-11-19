package es.marcosar.ejercicio5.dto;

import lombok.Value;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * DTO for {@link es.marcosar.ejercicio5.model.Reserva}
 */
@Value
public class ReservaDto implements Serializable {
    Long id;
    Long clienteId;
    Long habitacionId;
    LocalDateTime fecha_checkin;
    LocalDateTime fecha_checkout;
}