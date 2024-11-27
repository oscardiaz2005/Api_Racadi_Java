package com.Racadi.Academy.Racadi_Academy.Entidades;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;


@Entity
public class Clase {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_clase;

    @Enumerated(EnumType.STRING)
    private Sede sede;

    @Column(length = 20, nullable = false)
    private String nivel;

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


    @ManyToOne(targetEntity = Profesores.class)
    private Profesores profesor;

    @ManyToOne(targetEntity = Administrador.class)
    private Administrador administrador;

    @OneToMany(targetEntity = Reserva.class, fetch = FetchType.LAZY, mappedBy = "clase_reserva")
    private List<Reserva> reserva_clase;


    public Clase(){

    }

    public Clase(long id_clase, Sede sede, String nivel, LocalTime hora_inicio, LocalTime hora_fin, LocalDate fecha, String documento_profesor, int cupos, Profesores profesor) {
        this.id_clase = id_clase;
        this.sede = sede;
        this.nivel = nivel;
        this.hora_inicio = hora_inicio;
        this.hora_fin = hora_fin;
        this.fecha = fecha;
        this.documento_profesor = documento_profesor;
        this.cupos = cupos;
        this.profesor = profesor;
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

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel_enum) {
        this.nivel = nivel;
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

    public Profesores getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesores profesor) {
        this.profesor = profesor;
    }

    public Administrador getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }
}
