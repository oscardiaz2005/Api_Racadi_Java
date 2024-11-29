package com.Racadi.Academy.Racadi_Academy.Entidades;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name = "clases")
public class Clase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_clase;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Sede sede;

    @Column(length = 20, nullable = false)
    private String nivel;

    @Column(nullable = false)
    private LocalTime hora_inicio;

    @Column(nullable = false)
    private LocalTime hora_fin;

    @Column(nullable = false)
    private LocalDate fecha;

    @Column(name = "documento_profesor", nullable = false, length = 15)
    private String documentoProfesor;

    @Column(nullable = false)
    private int cupos;

    @ManyToOne
    @JoinColumn(name = "documento_profesor", referencedColumnName = "documento" , insertable=false, updatable=false)
    private Profesor profesor;


    @Column(name = "administrador", nullable = true , insertable=false, updatable=false)
    private int administradorId;

    @ManyToOne
    @JoinColumn(name = "administrador", referencedColumnName = "administrador_id")
    private Administrador administrador;


    @OneToMany(mappedBy = "id_clase", fetch = FetchType.LAZY)
    private List<Reserva> reservas;

    public Clase() {}

    public Clase(Sede sede, String nivel, LocalTime hora_inicio, LocalTime hora_fin, LocalDate fecha,String documentoProfesor, int cupos, int administradorId) {
        this.sede = sede;
        this.nivel = nivel;
        this.hora_inicio = hora_inicio;
        this.hora_fin = hora_fin;
        this.fecha = fecha;
        this.documentoProfesor = documentoProfesor;
        this.cupos = cupos;
        this.administradorId = administradorId;
    }

    // Getters y setters
    public int getId_clase() {
        return id_clase;
    }

    public void setId_clase(int id_clase) {
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

    public void setNivel(String nivel) {
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

    public String getDocumentoProfesor() {
        return documentoProfesor;
    }

    public void setDocumentoProfesor(String documentoProfesor) {
        this.documentoProfesor = documentoProfesor;
    }

    public int getCupos() {
        return cupos;
    }

    public void setCupos(int cupos) {
        this.cupos = cupos;
    }

    public int getAdministradorId() {
        return administradorId;
    }

    public void setAdministradorId(int administradorId) {
        this.administradorId = administradorId;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public Administrador getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }
}
