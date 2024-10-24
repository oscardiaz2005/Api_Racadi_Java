package com.Racadi.Academy.Racadi_Academy.Entidades;


import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Observacion {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long observacion;

    @Column(nullable = false)
    private Date fecha;

    @Column(length = 300, nullable = false)
    private String descripcion;


    @Column(length = 50, nullable = false)
    private String creada_por;


    public Observacion(){

    }

    public Observacion(long observacion, Date fecha, String descripcion, String creada_por) {
        this.observacion = observacion;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.creada_por = creada_por;
    }

    public long getObservacion() {
        return observacion;
    }

    public void setObservacion(long observacion) {
        this.observacion = observacion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCreada_por() {
        return creada_por;
    }

    public void setCreada_por(String creada_por) {
        this.creada_por = creada_por;
    }
}
