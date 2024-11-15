package es.marcosar.ejercicio5.dto;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link es.marcosar.ejercicio5.model.Habitacion}
 */
@Value
public class HabitacionDto implements Serializable {
    Integer numero;
    String tipo;
    Float precio;
}