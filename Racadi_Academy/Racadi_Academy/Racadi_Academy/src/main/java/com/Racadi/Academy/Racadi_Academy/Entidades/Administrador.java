package com.Racadi.Academy.Racadi_Academy.Entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;


@Entity
public class Administrador {

    @Id
    private String documento;


    @Column(nullable = false, length = 20)
    private String usuario;

    @Column(nullable = false, length = 20)
    private String contrasena;

    public Administrador(){

    }

    public Administrador(String documento, String usuario, String contrasena) {
        this.documento = documento;
        this.usuario = usuario;
        this.contrasena = contrasena;
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
}
