package com.Racadi.Academy.Racadi_Academy.Entidades;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "registro_estudiante_nivel")
public class RegistroEstudianteNivel implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "documento", referencedColumnName = "documento", nullable = false)
    private Estudiante estudiante;

    @Id
    @ManyToOne
    @JoinColumn(name = "nivel", referencedColumnName = "nombre_nivel", nullable = false)
    private Nivel nivel;

    @Column(nullable = false)
    private float speaking;

    @Column(nullable = false)
    private float listening;

    @Column(nullable = false)
    private float reading;

    @Column(nullable = false)
    private float writing;

    @Column(nullable = false)
    private float grammar;

    @Column(nullable = true)
    private Float notaEvaluacion;

    @Column(nullable = true)
    private Boolean aprobacion;

    // Constructor vacío
    public RegistroEstudianteNivel() {
    }

    // Constructor con parámetros
    public RegistroEstudianteNivel(Estudiante estudiante, Nivel nivel, float speaking, float listening, float reading,
                                   float writing, float grammar, Float notaEvaluacion, Boolean aprobacion) {
        this.estudiante = estudiante;
        this.nivel = nivel;
        this.speaking = speaking;
        this.listening = listening;
        this.reading = reading;
        this.writing = writing;
        this.grammar = grammar;
        this.notaEvaluacion = notaEvaluacion;
        this.aprobacion = aprobacion;
    }

    // Getters y setters
    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public Nivel getNivel() {
        return nivel;
    }

    public void setNivel(Nivel nivel) {
        this.nivel = nivel;
    }

    public float getSpeaking() {
        return speaking;
    }

    public void setSpeaking(float speaking) {
        this.speaking = speaking;
    }

    public float getListening() {
        return listening;
    }

    public void setListening(float listening) {
        this.listening = listening;
    }

    public float getReading() {
        return reading;
    }

    public void setReading(float reading) {
        this.reading = reading;
    }

    public float getWriting() {
        return writing;
    }

    public void setWriting(float writing) {
        this.writing = writing;
    }

    public float getGrammar() {
        return grammar;
    }

    public void setGrammar(float grammar) {
        this.grammar = grammar;
    }

    public Float getNotaEvaluacion() {
        return notaEvaluacion;
    }

    public void setNotaEvaluacion(Float notaEvaluacion) {
        this.notaEvaluacion = notaEvaluacion;
    }

    public Boolean getAprobacion() {
        return aprobacion;
    }

    public void setAprobacion(Boolean aprobacion) {
        this.aprobacion = aprobacion;
    }

    // Método para calcular automáticamente la nota de evaluación
    @PrePersist
    @PreUpdate
    public void calcularNotaEvaluacion() {
        this.notaEvaluacion = (this.speaking + this.listening + this.reading + this.writing + this.grammar) / 5.0f;
        this.aprobacion = this.notaEvaluacion >= 3.0;
    }
}

