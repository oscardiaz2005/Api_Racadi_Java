package com.Racadi.Academy.Racadi_Academy.Entidades;


import jakarta.persistence.*;

@Entity
public class Profesores {

    @Id
    private String documento;

    @Enumerated(EnumType.STRING)
    private tipo_documento tipo_documento;

    @Column(nullable = false, length = 20)
    private String nombre;

    @Column(nullable = false, length = 20)
    private String apellido;

    @Column(nullable = false, length = 20)
    private String celular;

    @Column(nullable = false, length = 120)
    private String correo;

    @Column(nullable = false, length = 20)
    private String usuario;

    @Column(nullable = false, length = 20)
    private String contraseña;

    public Profesores(){

    }

    public Profesores(String documento, tipo_documento tipo_documento, String nombre, String apellido, String celular, String correo, String usuario, String contraseña) {
        this.documento = documento;
        this.tipo_documento = tipo_documento;
        this.nombre = nombre;
        this.apellido = apellido;
        this.celular = celular;
        this.correo = correo;
        this.usuario = usuario;
        this.contraseña = contraseña;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public com.Racadi.Academy.Racadi_Academy.Entidades.tipo_documento getTipo_documento() {
        return tipo_documento;
    }

    public void setTipo_documento(com.Racadi.Academy.Racadi_Academy.Entidades.tipo_documento tipo_documento) {
        this.tipo_documento = tipo_documento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
}
