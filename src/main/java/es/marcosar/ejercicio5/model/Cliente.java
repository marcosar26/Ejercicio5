package es.marcosar.ejercicio5.model;

import com.fasterxml.jackson.annotation.*;
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
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;

    private String nombre;

    private String apellido;

    @Column(unique = true)
    private String correo;

    private Integer telefono;

    private String pais_origen;

    @OneToMany(mappedBy = "cliente", orphanRemoval = true)
    @JsonManagedReference(value = "cliente-reservas")
    private List<Reserva> reservas = new ArrayList<>();
}