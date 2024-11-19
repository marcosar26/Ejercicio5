package es.marcosar.ejercicio5.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CrearReservaDTO {
    private LocalDateTime fecha_checkin;

    private LocalDateTime fecha_checkout;
}
