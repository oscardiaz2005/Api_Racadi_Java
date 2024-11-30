package com.Racadi.Academy.Racadi_Academy.Entidades;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "asistencias")
public class Asistencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_asistencia;

    @ManyToOne
    @JoinColumn(name = "id_reserva", nullable = false,  foreignKey = @ForeignKey(name = "fk_reserva_asistencia"))
    private Reserva reserva;

    @Column
    private boolean asistencia = false;

    public Asistencia() {
    }

    public Asistencia(int id_asistencia, boolean asistencia, Reserva reserva) {
        this.id_asistencia = id_asistencia;
        this.asistencia = asistencia;
        this.reserva = reserva;
    }

    public int getId_asistencia() {
        return id_asistencia;
    }

    public void setId_asistencia(int id_asistencia) {
        this.id_asistencia = id_asistencia;
    }

    public boolean isAsistencia() {
        return asistencia;
    }

    public void setAsistencia(boolean asistencia) {
        this.asistencia = asistencia;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }
}
