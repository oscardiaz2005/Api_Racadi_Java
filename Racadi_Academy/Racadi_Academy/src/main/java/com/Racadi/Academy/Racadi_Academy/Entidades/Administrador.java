package com.Racadi.Academy.Racadi_Academy.Entidades;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

import java.util.List;


@Entity
public class Administrador {

    @Id
    private String documento;


    @Column(nullable = false, length = 20)
    private String usuario;

    @Column(nullable = false, length = 20)
    private String contrasena;

    @Column(nullable = false, columnDefinition = "VARCHAR(20) DEFAULT 'administrador'")
    private String rol;


    @OneToMany(targetEntity = Clase.class, fetch = FetchType.LAZY, mappedBy = "administrador")
    private List<Clase> administrador;

    @OneToMany(targetEntity = Comunicado.class, fetch = FetchType.LAZY, mappedBy = "documento_admin")
    private List<Comunicado> documento_comunicado;



    public Administrador(){

    }

    public Administrador(String documento, String usuario, String contrasena, String rol) {
        this.documento = documento;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.rol = rol;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}
