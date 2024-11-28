package com.Racadi.Academy.Racadi_Academy.Entidades;

import jakarta.persistence.*;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Entity
public class Asistencia {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_asistencia;

    @Column(columnDefinition = "boolean default false")
    private boolean asistencia = false;


    @ManyToOne(targetEntity = Reserva.class)
    private Reserva reserva;



    public Asistencia(){

    }

    public Asistencia(long id_asistencia, boolean asistencia, Reserva reserva) {
        this.id_asistencia = id_asistencia;
        this.asistencia = asistencia;
        this.reserva = reserva;
    }

    public long getId_asistencia() {
        return id_asistencia;
    }

    public void setId_asistencia(long id_asistencia) {
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
