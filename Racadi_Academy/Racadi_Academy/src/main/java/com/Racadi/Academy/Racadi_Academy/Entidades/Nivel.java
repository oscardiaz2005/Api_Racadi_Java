package com.Racadi.Academy.Racadi_Academy.Entidades;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name ="niveles" )
public class Nivel {

    @Id
    @Column(length = 30, nullable = false)
    private String nombre_nivel;

    @Column(length = 300, nullable = false)
    private String descripcion_nivel;

    @OneToMany(targetEntity = RegistroEstudianteNivel.class, fetch = FetchType.LAZY, mappedBy = "nivel")
    private List<RegistroEstudianteNivel> registro_nivel;


    public Nivel() {}

    public Nivel(String nombre_nivel, String descripcion_nivel) {
        this.nombre_nivel = nombre_nivel;
        this.descripcion_nivel = descripcion_nivel;
    }

    public String getNombre_nivel() {
        return nombre_nivel;
    }

    public void setNombre_nivel(String nombre_nivel) {
        this.nombre_nivel = nombre_nivel;
    }

    public String getDescripcion_nivel() {
        return descripcion_nivel;
    }

    public void setDescripcion_nivel(String descripcion_nivel) {
        this.descripcion_nivel = descripcion_nivel;
    }



}
