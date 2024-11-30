package com.Racadi.Academy.Racadi_Academy.Entidades;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.Date;

@Entity
@Table(name = "pagos")
public class Pago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_pago;

    @Column(nullable = false)
    private Date fecha;

    @Column(nullable = false)
    private int valor;  // Cambié calor por valor, como en el modelo de Python

    @ManyToOne
    @JoinColumn(name = "cuenta_documento", referencedColumnName = "documento", nullable = false, foreignKey = @ForeignKey(name = "fk_cuenta_pago"))
    @OnDelete(action = OnDeleteAction.CASCADE)  // Aquí se implementa el CASCADE
    private Cuenta cuenta_documento;

    // Constructor vacío
    public Pago() {
    }

    // Constructor con parámetros
    public Pago(int id_pago, Date fecha, int valor, Cuenta cuenta_documento) {
        this.id_pago = id_pago;
        this.fecha = fecha;
        this.valor = valor;
        this.cuenta_documento = cuenta_documento;
    }

    // Getters y setters
    public int getId_pago() {
        return id_pago;
    }

    public void setId_pago(int id_pago) {
        this.id_pago = id_pago;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public Cuenta getCuenta_documento() {
        return cuenta_documento;
    }

    public void setCuenta_documento(Cuenta cuenta_documento) {
        this.cuenta_documento = cuenta_documento;
    }
}
