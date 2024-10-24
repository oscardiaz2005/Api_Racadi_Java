package com.Racadi.Academy.Racadi_Academy.Entidades;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;


@Entity
public class Clase {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_clase;

    @Enumerated(EnumType.STRING)
    private Sede sede;

    @Enumerated(EnumType.STRING)
    private nivel_enum nivel_enum;

    @Column(nullable = false)
    private LocalTime hora_inicio;

    @Column(nullable = false)
    private LocalTime hora_fin;

    @Column(nullable = false)
    private LocalDate fecha;

    @Column(length = 15, nullable = false)
    private String documento_profesor;

    @Column(nullable = false)
    private int cupos;



    public Clase(){

    }

    public Clase(long id_clase, Sede sede, com.Racadi.Academy.Racadi_Academy.Entidades.nivel_enum nivel_enum, LocalTime hora_inicio, LocalTime hora_fin, LocalDate fecha, String documento_profesor, int cupos) {
        this.id_clase = id_clase;
        this.sede = sede;
        this.nivel_enum = nivel_enum;
        this.hora_inicio = hora_inicio;
        this.hora_fin = hora_fin;
        this.fecha = fecha;
        this.documento_profesor = documento_profesor;
        this.cupos = cupos;
    }

    public long getId_clase() {
        return id_clase;
    }

    public void setId_clase(long id_clase) {
        this.id_clase = id_clase;
    }

    public Sede getSede() {
        return sede;
    }

    public void setSede(Sede sede) {
        this.sede = sede;
    }

    public com.Racadi.Academy.Racadi_Academy.Entidades.nivel_enum getNivel_enum() {
        return nivel_enum;
    }

    public void setNivel_enum(com.Racadi.Academy.Racadi_Academy.Entidades.nivel_enum nivel_enum) {
        this.nivel_enum = nivel_enum;
    }

    public LocalTime getHora_inicio() {
        return hora_inicio;
    }

    public void setHora_inicio(LocalTime hora_inicio) {
        this.hora_inicio = hora_inicio;
    }

    public LocalTime getHora_fin() {
        return hora_fin;
    }

    public void setHora_fin(LocalTime hora_fin) {
        this.hora_fin = hora_fin;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getDocumento_profesor() {
        return documento_profesor;
    }

    public void setDocumento_profesor(String documento_profesor) {
        this.documento_profesor = documento_profesor;
    }

    public int getCupos() {
        return cupos;
    }

    public void setCupos(int cupos) {
        this.cupos = cupos;
    }
}
