package es.marcosar.ejercicio5.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id"
)
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
    private List<Reserva> reservas = new ArrayList<>();
}