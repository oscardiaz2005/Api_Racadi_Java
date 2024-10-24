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

    public Asistencia(){

    }

    public Asistencia(long id_asistencia, boolean asistencia) {
        this.id_asistencia = id_asistencia;
        this.asistencia = asistencia;
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
}
