package es.marcosar.ejercicio5.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "habitacion")
public class Habitacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(unique = true)
    private Integer numero;

    private String tipo;

    private Integer capacidad;

    private Float precio;

    private Boolean disponible;

    @OneToMany(mappedBy = "habitacion")
    private List<Reserva> reservas = new ArrayList<>();
}