package com.Racadi.Academy.Racadi_Academy.Entidades;

import jakarta.persistence.*;


@Entity
public class Comunicado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_comunicado;

    @Column(nullable = false, length = 20)
    private String titulo;

    @Column(nullable = false, length = 50)
    private String descripcion;

    @Column(nullable = false, length = 300)
    private String foto;

    @ManyToOne(targetEntity = Administrador.class)
    private Administrador documento_admin;



    public Comunicado(){

    }

    public Comunicado(long id_comunicado, String titulo, String descripcion, String foto, Administrador documento_admin) {
        this.id_comunicado = id_comunicado;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.foto = foto;
        this.documento_admin = documento_admin;
    }

    public long getId_comunicado() {
        return id_comunicado;
    }

    public void setId_comunicado(long id_comunicado) {
        this.id_comunicado = id_comunicado;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Administrador getDocumento_admin() {
        return documento_admin;
    }

    public void setDocumento_admin(Administrador documento_admin) {
        this.documento_admin = documento_admin;
    }
}
