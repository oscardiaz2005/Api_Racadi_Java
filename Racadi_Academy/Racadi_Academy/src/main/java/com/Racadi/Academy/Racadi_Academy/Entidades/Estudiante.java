package com.Racadi.Academy.Racadi_Academy.Entidades;

import jakarta.persistence.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "estudiantes")
public class Estudiante {

    @Id
    @Column(length = 15, nullable = false)
    private String documento;

    @Column(nullable = false, length = 30)
    private String tipo_de_documento;

    @Column(nullable = false, length = 20)
    private String nombre;

    @Column(nullable = false, length = 20)
    private String apellido;

    @Column(nullable = false)
    private Date fecha_nacimiento;

    @Enumerated(EnumType.STRING)
    private Genero genero;

    @Column(nullable = false, length = 10)
    private String celular;

    @Column(nullable = false, length = 120)
    private String correo;

    @Column(nullable = false, length = 200)
    private String direccion;

    @Enumerated(EnumType.STRING)
    private Sede sede;

    @Column(nullable = false, length = 30)
    private String usuario;

    @Column(nullable = false, length = 60)
    private String contraseña;

    @Column(nullable = false, length = 20)
    private String nivel_actual;

    @Column(nullable = false)
    private LocalDate fecha_inscripcion;

    @Column(nullable = false)
    private String plan;

    @Column(nullable = true, length = 300)
    private String foto_perfil;

    @OneToMany(mappedBy = "documento_estudiante", fetch = FetchType.LAZY)
    private List<Reserva> reservas;

    @OneToMany(mappedBy = "documento", fetch = FetchType.LAZY)
    private List<Cuenta> cuentas;

    @OneToMany(mappedBy = "estudiante", fetch = FetchType.LAZY)
    private List<Observacion> observaciones;

    @OneToMany(mappedBy = "documento", fetch = FetchType.LAZY)
    private List<Solicitud> solicitudes;




    public Estudiante() {}

    public Estudiante(String documento, String tipo_de_documento, String nombre, String apellido, Date fecha_nacimiento, Genero genero, String celular, String correo, String direccion, Sede sede, String usuario, String contraseña, String nivel_actual,String plan, String foto_perfil) {
        this.documento = documento;
        this.tipo_de_documento = tipo_de_documento;
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
        this.nivel_actual = nivel_actual;
        this.plan=plan;
        this.foto_perfil = foto_perfil;
    }

    @PrePersist
    public void prePersist() {
        if (this.fecha_inscripcion == null) {
            this.fecha_inscripcion = LocalDate.now();
        }
    }

    public String getDocumento() {
        return documento;
    }

    public String getTipo_de_documento() {
        return tipo_de_documento;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
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

    public Sede getSede() {
        return sede;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public String getNivel_actual() {
        return nivel_actual;
    }

    public LocalDate getFecha_inscripcion() {
        return fecha_inscripcion;
    }

    public String getPlan() {
        return plan;
    }

    public String getFoto_perfil() {
        return foto_perfil;
    }


    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public void setTipo_de_documento(String tipo_de_documento) {
        this.tipo_de_documento = tipo_de_documento;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
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

    public void setSede(Sede sede) {
        this.sede = sede;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public void setNivel_actual(String nivel_actual) {
        this.nivel_actual = nivel_actual;
    }

    public void setFecha_inscripcion(LocalDate fecha_inscripcion) {
        this.fecha_inscripcion = fecha_inscripcion;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }

    public void setFoto_perfil(String foto_perfil) {
        this.foto_perfil = foto_perfil;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }
}
