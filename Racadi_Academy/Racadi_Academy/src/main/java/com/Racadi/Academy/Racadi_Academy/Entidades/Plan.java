package com.Racadi.Academy.Racadi_Academy.Entidades;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "planes")
public class Plan {

    @Id
    @Column(nullable = false, length = 30)
    private String nombre; // El nombre del plan es la clave primaria

    @Column(nullable = false)
    private int horas_semanales;

    @Column(nullable = false)
    private int costo;

    @Column(nullable = false)
    private int meses;

    // Constructor, Getters y Setters...

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getHoras_semanales() {
        return horas_semanales;
    }

    public void setHoras_semanales(int horas_semanales) {
        this.horas_semanales = horas_semanales;
    }

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }

    public int getMeses() {
        return meses;
    }

    public void setMeses(int meses) {
        this.meses = meses;
    }
}

