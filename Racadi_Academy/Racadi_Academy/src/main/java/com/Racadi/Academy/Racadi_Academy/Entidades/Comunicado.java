package com.Racadi.Academy.Racadi_Academy.Entidades;

import jakarta.persistence.*;

@Entity
@Table(name = "comunicados")
public class Comunicado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_comunicado;

    @ManyToOne
    @JoinColumn(name = "administrador_id", referencedColumnName = "administrador_id", nullable = true,
            foreignKey = @ForeignKey(name = "fk_administrador_id"))
    private Administrador administrador_id;


    @Column(nullable = false, length = 400)
    private String titulo;

    @Column(nullable = false, length = 400)
    private String descripcion;

    @Column(nullable = true, length = 300)
    private String foto;


    public Comunicado() {

    }

    // Constructor con parámetros
    public Comunicado(long id_comunicado, String titulo, String descripcion, String foto, Administrador administrador_id) {
        this.id_comunicado = id_comunicado;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.foto = foto;
        this.administrador_id = administrador_id;
    }

    // Getters y setters
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

    public Administrador getAdministrador_id() {
        return administrador_id;
    }

    public void setDocumento_admin(Administrador documento_admin) {
        this.administrador_id = administrador_id;
    }
}
