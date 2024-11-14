package es.marcosar.ejercicio5.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String nombre;

    private String apellido;

    @Column(unique = true)
    private String correo;

    private Integer telefono;

    private String pais_origen;

    @OneToMany(mappedBy = "cliente")
    private List<Reserva> reservas = new ArrayList<>();
}