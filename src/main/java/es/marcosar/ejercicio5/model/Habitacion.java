package es.marcosar.ejercicio5.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Habitacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;

    @Column(unique = true)
    private Integer numero;

    private String tipo;

    private Integer capacidad;

    private Float precio;

    private Boolean disponible;

    @OneToMany(mappedBy = "habitacion", orphanRemoval = true)
    @JsonManagedReference
    private List<Reserva> reservas = new ArrayList<>();
}