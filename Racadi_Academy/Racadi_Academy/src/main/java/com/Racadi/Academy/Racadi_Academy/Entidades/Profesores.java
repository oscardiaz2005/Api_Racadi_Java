package com.Racadi.Academy.Racadi_Academy.Entidades;


import jakarta.persistence.*;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Profesores {

    @Id
    private String documento;

    @Column(nullable = false, length = 20)
    private String tipo_documento;

    @Column(nullable = false, length = 20)
    private String nombre;

    @Column(nullable = false, length = 20)
    private String apellido;

    @Column(nullable = false)
    private Date fecha_nacimiento;

    @Enumerated(EnumType.STRING)
    private genero genero;


    @Column(nullable = false, length = 20)
    private String celular;

    @Column(nullable = false, length = 120)
    private String correo;


    @Column(nullable = false, length = 20)
    private String direccion;


    @Column(nullable = false, length = 20)
    private String usuario;


    @Column(nullable = false, length = 20)
    private String contrasena;

    @Column(nullable = true)
    private LocalDate fecha_contratacion;

    @Column(nullable = true, length = 300)
    private String foto_perfil;

    @Column(nullable = false, columnDefinition = "VARCHAR(20) DEFAULT 'profesor'")
    private String rol;



    @OneToMany(targetEntity = Clase.class, fetch = FetchType.LAZY, mappedBy = "profesor")
    private List<Clase> clase_profe;


    public Profesores(){

    }

    public Profesores(String documento, String tipo_documento, String nombre, String apellido, Date fecha_nacimiento, com.Racadi.Academy.Racadi_Academy.Entidades.genero genero, String celular, String correo, String direccion, String usuario, String contrasena, String rol) {
        this.documento = documento;
        this.tipo_documento = tipo_documento;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fecha_nacimiento = fecha_nacimiento;
        this.genero = genero;
        this.celular = celular;
        this.correo = correo;
        this.direccion = direccion;
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

    public String getTipo_documento() {
        return tipo_documento;
    }

    public void setTipo_documento(String tipo_documento) {
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

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public com.Racadi.Academy.Racadi_Academy.Entidades.genero getGenero() {
        return genero;
    }

    public void setGenero(com.Racadi.Academy.Racadi_Academy.Entidades.genero genero) {
        this.genero = genero;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public LocalDate getFecha_contratacion() {
        return fecha_contratacion;
    }

    public void setFecha_contratacion(LocalDate fecha_contratacion) {
        this.fecha_contratacion = fecha_contratacion;
    }

    public String getFoto_perfil() {
        return foto_perfil;
    }

    public void setFoto_perfil(String foto_perfil) {
        this.foto_perfil = foto_perfil;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}
