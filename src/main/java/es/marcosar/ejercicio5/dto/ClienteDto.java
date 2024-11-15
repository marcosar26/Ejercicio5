package es.marcosar.ejercicio5.dto;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link es.marcosar.ejercicio5.model.Cliente}
 */
@Value
public class ClienteDto implements Serializable {
    String nombre;
    String correo;
}