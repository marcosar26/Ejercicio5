package es.marcosar.ejercicio5.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id"
)
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "habitacion_id")
    private Habitacion habitacion;

    private LocalDateTime fecha_checkin;

    private LocalDateTime fecha_checkout;

    public Reserva(Cliente cliente, Habitacion habitacion, LocalDateTime fecha_checkin, LocalDateTime fecha_checkout) {
        this.cliente = cliente;
        this.habitacion = habitacion;
        this.fecha_checkin = fecha_checkin;
        this.fecha_checkout = fecha_checkout;
    }
}