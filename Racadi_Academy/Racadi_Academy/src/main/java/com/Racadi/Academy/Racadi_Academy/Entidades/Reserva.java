package com.Racadi.Academy.Racadi_Academy.Entidades;


import jakarta.persistence.*;

import java.util.List;

@Entity
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_reserva;

    @Column(nullable = false, length = 20)
    private String documento_estudiante;

    @ManyToOne(targetEntity = Clase.class)
    private Clase clase_reserva;

    @ManyToOne(targetEntity = Estudiantes.class)
    private Estudiantes estudiante_documento;

    @OneToMany(targetEntity = Asistencia.class, fetch = FetchType.LAZY, mappedBy = "reserva")
    private List<Asistencia> asistencia_reserva;

    public Reserva(){}

    public Reserva(long id_reserva, String documento_estudiante) {
        this.id_reserva = id_reserva;
        this.documento_estudiante = documento_estudiante;
    }

    public Reserva(long id_reserva) {
        this.id_reserva = id_reserva;
    }

    public long getId_reserva() {
        return id_reserva;
    }

    public void setId_reserva(long id_reserva) {
        this.id_reserva = id_reserva;
    }

    public Clase getClase_reserva() {
        return clase_reserva;
    }

    public void setClase_reserva(Clase clase_reserva) {
        this.clase_reserva = clase_reserva;
    }

    public Estudiantes getEstudiante_documento() {
        return estudiante_documento;
    }

    public void setEstudiante_documento(Estudiantes estudiante_documento) {
        this.estudiante_documento = estudiante_documento;
    }

    public String getDocumento_estudiante() {
        return documento_estudiante;
    }

    public void setDocumento_estudiante(String documento_estudiante) {
        this.documento_estudiante = documento_estudiante;
    }
}
