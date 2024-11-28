package com.Racadi.Academy.Racadi_Academy.Entidades;


import jakarta.persistence.*;

import java.util.List;

@Entity
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_reserva;

    @Column(name = "documento_estudiante", nullable = false)
    private String documento_estudiante;


    @ManyToOne(targetEntity = Clase.class)
    private Clase clase_reserva;

    @ManyToOne(targetEntity = Estudiante.class)
    private Estudiante estudiante_documento;

    @OneToMany(targetEntity = Asistencia.class, fetch = FetchType.LAZY, mappedBy = "reserva")
    private List<Asistencia> asistencia_reserva;

    public Reserva(){}

    public Reserva(long id_reserva, String documento_estudiante) {
        this.id_reserva = id_reserva;
        this.documento_estudiante = documento_estudiante;
    }

    public long getId_reserva() {
        return id_reserva;
    }

    public void setId_reserva(long id_reserva) {
        this.id_reserva = id_reserva;
    }

    public String getDocumento_estudiante() {
        return documento_estudiante;
    }

    public void setDocumento_estudiante(String documento_estudiante) {
        this.documento_estudiante = documento_estudiante;
    }
}
