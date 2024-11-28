package com.Racadi.Academy.Racadi_Academy.Entidades;

import jakarta.persistence.*;

@Entity
public class RegistroEstudianteNivel {

    @Id
    @Column(nullable = false, length = 20)
    private String documento;

    @Column(nullable = false)
    private Float speaking;

    @Column(nullable = false)
    private Float listening;

    @Column(nullable = false)
    private Float reading;

    @Column(nullable = false)
    private Float writing;

    @Column(nullable = false)
    private Float nota_evaluacion;


    @Column(columnDefinition = "boolean default false")
    private boolean aprobacion = false;

    @ManyToOne(targetEntity = Nivel.class)
    private Nivel nivel;

    @ManyToOne(targetEntity = Estudiante.class)
    private Estudiante documento_estudiante;

    public Nivel getNivel() {
        return nivel;
    }

    public void setNivel(Nivel nivel) {
        this.nivel = nivel;
    }

    public RegistroEstudianteNivel() {}

    public RegistroEstudianteNivel(String documento, Float speaking, Float listening, Float reading, Float writing, Float nota_evaluacion, boolean aprobacion, Nivel nivel, Estudiante documento_estudiante) {
        this.documento = documento;
        this.speaking = speaking;
        this.listening = listening;
        this.reading = reading;
        this.writing = writing;
        this.nota_evaluacion = nota_evaluacion;
        this.aprobacion = aprobacion;
        this.nivel = nivel;
        this.documento_estudiante = documento_estudiante;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public Float getSpeaking() {
        return speaking;
    }

    public void setSpeaking(Float speaking) {
        this.speaking = speaking;
    }

    public Float getListening() {
        return listening;
    }

    public void setListening(Float listening) {
        this.listening = listening;
    }

    public Float getReading() {
        return reading;
    }

    public void setReading(Float reading) {
        this.reading = reading;
    }

    public Float getWriting() {
        return writing;
    }

    public void setWriting(Float writing) {
        this.writing = writing;
    }

    public Float getNota_evaluacion() {
        return nota_evaluacion;
    }

    public void setNota_evaluacion(Float nota_evaluacion) {
        this.nota_evaluacion = nota_evaluacion;
    }

    public boolean isAprobacion() {
        return aprobacion;
    }

    public void setAprobacion(boolean aprobacion) {
        this.aprobacion = aprobacion;
    }

    public Estudiante getDocumento_estudiante() {
        return documento_estudiante;
    }

    public void setDocumento_estudiante(Estudiante documento_estudiante) {
        this.documento_estudiante = documento_estudiante;
    }

}
