package com.Racadi.Academy.Racadi_Academy.Entidades;

import jakarta.persistence.*;
import java.util.Date;
import java.text.SimpleDateFormat;

@Entity
public class Solicitud {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_solicitud;

    @Column(nullable = false, length = 400)
    private String descripcion;

    @Column(nullable = true, length = 400)
    private String respuesta;

    @Column(columnDefinition = "boolean default false")
    private boolean contestacion = false;

    @Column(updatable = false, nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fecha_creacion; // Cambiado a Date

    public Solicitud() {
        this.fecha_creacion = new Date(); // Inicializar con la fecha actual
    }

    public Solicitud(long id_solicitud, String descripcion, String respuesta, boolean contestacion) {
        this.id_solicitud = id_solicitud;
        this.descripcion = descripcion;
        this.respuesta = respuesta;
        this.contestacion = contestacion;
        this.fecha_creacion = new Date(); // Asignar la fecha actual
    }

    public long getId_solicitud() {
        return id_solicitud;
    }

    public void setId_solicitud(long id_solicitud) {
        this.id_solicitud = id_solicitud;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public boolean isContestacion() {
        return contestacion;
    }

    public void setContestacion(boolean contestacion) {
        this.contestacion = contestacion;
    }

    public Date getFecha_creacion() {
        return fecha_creacion;
    }

    // Si realmente necesitas un setter para fecha_creacion, puedes dejarlo
    public void setFecha_creacion(Date fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public String fecha() {
        SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
        return formato.format(fecha_creacion); // Usar fecha_creacion
    }
}
