package com.Racadi.Academy.Racadi_Academy.Entidades;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "profesores")
public class Profesor {

    @Id
    @Column(length = 15, nullable = false)
    private String documento;

    @Column(name = "tipo_de_documento", nullable = false, length = 30)
    private String tipoDeDocumento;

    @Column(nullable = false, length = 20)
    private String nombre;

    @Column(nullable = false, length = 20)
    private String apellido;

    @Column(name = "fecha_nacimiento", nullable = false)
    private LocalDate fechaNacimiento;

    @Enumerated(EnumType.STRING)
    private Genero genero;

    @Column(nullable = false, length = 10)
    private String celular;

    @Column(nullable = false, length = 30)
    private String correo;

    @Column(nullable = false, length = 200)
    private String direccion;

    @Column(nullable = false, length = 30)
    private String usuario;

    @Column(nullable = false, length = 60)
    private String contraseña;

    @Column(name = "fecha_contratacion", nullable = true)
    private LocalDate fechaContratacion;

    @Column(name = "foto_perfil", nullable = true, length = 300)
    private String fotoPerfil;

    @OneToMany(mappedBy = "profesor", fetch = FetchType.LAZY)
    private List<Clase> clases;


    public Profesor() {
    }

    public Profesor(String documento, String tipoDeDocumento, String nombre, String apellido, LocalDate fechaNacimiento, Genero genero, String celular, String correo, String direccion, String usuario, String contraseña, LocalDate fechaContratacion, String fotoPerfil) {
        this.documento = documento;
        this.tipoDeDocumento = tipoDeDocumento;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.genero = genero;
        this.celular = celular;
        this.correo = correo;
        this.direccion = direccion;
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.fechaContratacion = fechaContratacion != null ? fechaContratacion : LocalDate.now();
        this.fotoPerfil = fotoPerfil;
    }

    @PrePersist
    public void prePersist() {
        if (this.fechaContratacion == null) {
            this.fechaContratacion = LocalDate.now();
        }
    }

    // Getters y Setters

    public String getDocumento() {
        return documento;
    }

    public String getTipoDeDocumento() {
        return tipoDeDocumento;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public Genero getGenero() {
        return genero;
    }

    public String getCelular() {
        return celular;
    }

    public String getCorreo() {
        return correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public LocalDate getFechaContratacion() {
        return fechaContratacion;
    }

    public String getFotoPerfil() {
        return fotoPerfil;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public void setTipoDeDocumento(String tipoDeDocumento) {
        this.tipoDeDocumento = tipoDeDocumento;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public void setFechaContratacion(LocalDate fechaContratacion) {
        this.fechaContratacion = fechaContratacion;
    }

    public void setFotoPerfil(String fotoPerfil) {
        this.fotoPerfil = fotoPerfil;
    }

    public List<Clase> getClases() {
        return clases;
    }

    public void setClases(List<Clase> clases) {
        this.clases = clases;
    }
}
