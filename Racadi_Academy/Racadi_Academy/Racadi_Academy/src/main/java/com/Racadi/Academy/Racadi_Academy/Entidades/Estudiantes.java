package com.Racadi.Academy.Racadi_Academy.Entidades;

import jakarta.persistence.*;

import java.sql.Date;
import java.time.LocalDate;


@Entity
public class Estudiantes {

    @Id
    private String documento;

    @Enumerated(EnumType.STRING)
    private tipo_documento tipo_documento;

    @Column(nullable = false, length = 20)
    private String nombre;

    @Column(nullable = false, length = 20)
    private String apellido;

    @Column(nullable = false)
    private Date fecha_nacimiento;


    @Enumerated(EnumType.STRING)
    private genero genero;

    @Column(nullable = false, length = 10)
    private String celular;

    @Column(nullable = false, length = 120)
    private String correo;

    @Column(nullable = false, length = 120)
    private String direccion;

    @Enumerated(EnumType.STRING)
    private Sede sede;

    @Column(nullable = false, length = 20)
    private String usuario;

    @Column(nullable = false, length = 20)
    private String contraseña;

    @Enumerated(EnumType.STRING)
    private nivel_enum nivel;


    @Column(nullable = false)
    private LocalDate fecha_inscripcion;


    @Column(nullable = true, length = 300)
    private String foto_perfil;


    public Estudiantes(){

    }

    public Estudiantes(String documento, com.Racadi.Academy.Racadi_Academy.Entidades.tipo_documento tipo_documento, String nombre, String apellido, Date fecha_nacimiento, com.Racadi.Academy.Racadi_Academy.Entidades.genero genero, String celular, String correo, String direccion, Sede sede, String usuario, String contraseña, nivel_enum nivel, LocalDate fecha_inscripcion, String foto_perfil) {
        this.documento = documento;
        this.tipo_documento = tipo_documento;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fecha_nacimiento = fecha_nacimiento;
        this.genero = genero;
        this.celular = celular;
        this.correo = correo;
        this.direccion = direccion;
        this.sede = sede;
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.nivel = nivel;
        this.fecha_inscripcion = fecha_inscripcion;
        this.foto_perfil = foto_perfil;
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Sede getSede() {
        return sede;
    }

    public void setSede(Sede sede) {
        this.sede = sede;
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

    public nivel_enum getNivel() {
        return nivel;
    }

    public void setNivel(nivel_enum nivel) {
        this.nivel = nivel;
    }

    public LocalDate getFecha_inscripcion() {
        return fecha_inscripcion;
    }

    public void setFecha_inscripcion(LocalDate fecha_inscripcion) {
        this.fecha_inscripcion = fecha_inscripcion;
    }

    public String getFoto_perfil() {
        return foto_perfil;
    }

    public void setFoto_perfil(String foto_perfil) {
        this.foto_perfil = foto_perfil;
    }
}
