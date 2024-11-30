package com.Racadi.Academy.Racadi_Academy.Entidades;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.Date;

@Entity
@Table(name = "observaciones")
public class Observacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_observacion")
    private int id_observacion;

    @Column(name = "fecha", nullable = true)
    private Date fecha;

    @Column(name = "descripcion", length = 300, nullable = false)
    private String descripcion;

    @Column(name = "creada_por", length = 50, nullable = false)
    private String creada_por;

    @ManyToOne
    @JoinColumn(name = "documento", referencedColumnName = "documento", foreignKey = @ForeignKey(name = "fk_estudiante_observacion"))
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Estudiante estudiante;

    public Observacion() {}

    public Observacion(int id_observacion, Date fecha, String descripcion, String creada_por, Estudiante estudiante) {
        this.id_observacion = id_observacion;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.creada_por = creada_por;
        this.estudiante = estudiante;
    }

    @PrePersist
    public void prePersist() {
        if (this.fecha == null) {
            this.fecha = new Date(System.currentTimeMillis()); // Establece la fecha si es null
        }
    }


    public int getId_observacion() {
        return id_observacion;
    }

    public void setId_observacion(int id_observacion) {
        this.id_observacion = id_observacion;
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

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }
}
