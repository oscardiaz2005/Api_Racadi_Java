package com.Racadi.Academy.Racadi_Academy.Entidades;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

import java.util.List;


@Entity
public class Administrador {

    @Id
    private int administrador_id;


    @Column(nullable = false, length = 30)
    private String usuario;

    @Column(nullable = false, length = 60)
    private String contraseña;



    @OneToMany(mappedBy = "administrador_id")
    private List<Comunicado> comunicados;

    @OneToMany(mappedBy = "administrador")
    private List<Clase> clases;




    public Administrador(){

    }

    public Administrador(int administrador_id, String usuario, String contraseña) {
        this.administrador_id = administrador_id;
        this.usuario = usuario;
        this.contraseña = contraseña;
    }

    public int getAdministrador_id() {
        return administrador_id;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setAdministrador_id(int administrador_id) {
        this.administrador_id = administrador_id;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
}
