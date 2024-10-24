package com.Racadi.Academy.Racadi_Academy.Entidades;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Plan {


    @Id
    @Column(nullable = false, length = 30)
    private String nombre;

    @Column(nullable = false)
    private int horas_semanales;

    @Column(nullable = false)
    private int costo;

    @Column(nullable = false)
    private int meses;

    public Plan(){

    }

    public Plan(String nombre, int horas_semanales, int costo, int meses) {
        this.nombre = nombre;
        this.horas_semanales = horas_semanales;
        this.costo = costo;
        this.meses = meses;
    }

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
