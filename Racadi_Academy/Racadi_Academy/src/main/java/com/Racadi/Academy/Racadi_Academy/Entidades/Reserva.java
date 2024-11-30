package com.Racadi.Academy.Racadi_Academy.Entidades;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.List;

@Entity
@Table(name = "reservas")
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_reserva;

    @ManyToOne
    @JoinColumn(name = "id_clase", nullable = false, foreignKey = @ForeignKey(name = "fk_clase_reserva"))
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Clase id_clase;

    @ManyToOne
    @JoinColumn(name = "documento_estudiante", nullable = false, foreignKey = @ForeignKey(name = "fk_estudiante_reserva"))
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Estudiante documento_estudiante;

    @OneToMany(mappedBy = "reserva", cascade = CascadeType.ALL)
    private List<Asistencia> asistencias;

    public Reserva() {
    }

    public Reserva(int id_reserva, Clase id_clase, Estudiante documento_estudiante) {
        this.id_reserva = id_reserva;
        this.id_clase = id_clase;
        this.documento_estudiante = documento_estudiante;
    }

    public int getId_reserva() {
        return id_reserva;
    }

    public void setId_reserva(int id_reserva) {
        this.id_reserva = id_reserva;
    }

    public Clase getId_clase() {
        return id_clase;
    }

    public void setId_clase(Clase id_clase) {
        this.id_clase = id_clase;
    }

    public Estudiante getDocumento_estudiante() {
        return documento_estudiante;
    }

    public void setDocumento_estudiante(Estudiante documento_estudiante) {
        this.documento_estudiante = documento_estudiante;
    }
}
