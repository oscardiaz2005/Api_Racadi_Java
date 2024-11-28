package com.Racadi.Academy.Racadi_Academy.Entidades;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;


@Entity
@Table(name = "estudiantes")
public class Estudiante {

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
    private String contrasena;

    @Column(nullable = false, length = 20)
    private String nivel;


    @Column(nullable = false)
    private LocalDate fecha_inscripcion;


    @Column(nullable = true, length = 300)
    private String foto_perfil;


    @Column(nullable = false, columnDefinition = "VARCHAR(20) DEFAULT 'estudiante'")
    private String rol;


    @OneToMany(targetEntity = RegistroEstudianteNivel.class, fetch = FetchType.LAZY, mappedBy = "documento_estudiante")
    private List<RegistroEstudianteNivel> documento_estu;

    @OneToMany(targetEntity = Observacion.class, fetch = FetchType.LAZY, mappedBy = "estudiante")
    private List<Observacion> documento_observaciones;

    @OneToMany(targetEntity = Cuenta.class, fetch = FetchType.LAZY, mappedBy = "documento_cuenta")
    private List<Cuenta> documento_cuenta;


    @OneToMany(targetEntity = Reserva.class, fetch = FetchType.LAZY, mappedBy = "estudiante_documento")
    private List<Reserva> reserva;


    @OneToMany(targetEntity = Solicitud.class, fetch = FetchType.LAZY, mappedBy = "documento")
    private List<Solicitud> documento_solicitudes;


    @OneToMany(targetEntity = Observacion.class, fetch = FetchType.LAZY, mappedBy = "")
    @JsonBackReference
    List<Observacion> observaciones_estudiantes;


    @ManyToOne
    @JoinColumn(name = "plan", referencedColumnName = "nombre", nullable = false)
    private Plan plan;

    public Estudiante(){

    }

    public Estudiante(String documento, String tipo_documento, String nombre, String apellido, Date fecha_nacimiento, com.Racadi.Academy.Racadi_Academy.Entidades.genero genero, String celular, String correo, String direccion, Sede sede, String usuario, String contrasena, String nivel, LocalDate fecha_inscripcion, String foto_perfil, String rol, Plan plan) {
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
        this.contrasena = contrasena;
        this.nivel = nivel;
        this.fecha_inscripcion = fecha_inscripcion;
        this.foto_perfil = foto_perfil;
        this.rol = rol;
        this.plan = plan;
    }

    public String getTipo_documento() {
        return tipo_documento;
    }

    public void setTipo_documento(String tipo_documento) {
        this.tipo_documento = tipo_documento;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
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

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
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

    public Plan getPlan() {
        return plan;
    }

    public void setPlan(Plan plan) {
        this.plan = plan;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}
