package com.Racadi.Academy.Racadi_Academy.Entidades;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "solicitudes")
public class Solicitud {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_solicitud;

    @Column(nullable = false, length = 400)
    private String descripcion;

    @Column(nullable = true, length = 400)
    private String respuesta;

    @Column(columnDefinition = "boolean default false")
    private boolean contestacion = false;

    @Column(updatable = false, nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fecha_creacion;

    @ManyToOne
    @JoinColumn(name = "documento", referencedColumnName = "documento", nullable = false,
            foreignKey = @ForeignKey(name = "fk_estudiante_solicitud"))
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Estudiante documento;
;

    // Constructor vacío
    public Solicitud() {
        this.fecha_creacion = new Date();  // Inicializar con la fecha actual
    }

    // Constructor con parámetros
    public Solicitud(int id_solicitud, String descripcion, String respuesta, boolean contestacion, Date fecha_creacion, Estudiante documento) {
        this.id_solicitud = id_solicitud;
        this.descripcion = descripcion;
        this.respuesta = respuesta;
        this.contestacion = contestacion;
        this.fecha_creacion = fecha_creacion;
        this.documento = documento;
    }

    // Getters y setters
    public int getId_solicitud() {
        return id_solicitud;
    }

    public void setId_solicitud(int id_solicitud) {
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

    public void setFecha_creacion(Date fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    // Método para formatear la fecha
    public String fecha() {
        SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
        return formato.format(fecha_creacion);  // Usar fecha_creacion
    }

    public Estudiante getDocumento() {
        return documento;
    }

    public void setDocumento(Estudiante documento) {
        this.documento = documento;
    }
}

