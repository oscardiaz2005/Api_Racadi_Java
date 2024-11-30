package com.Racadi.Academy.Racadi_Academy.Entidades;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.Date;

@Entity
@Table(name = "cuentas")
public class Cuenta {

    @Id
    @Column(nullable = false, length = 15)
    private String documento;

    @ManyToOne
    @JoinColumn(name = "documento", referencedColumnName = "documento", insertable = false, updatable = false)
    private Estudiante estudiante;

    @Column(nullable = true)
    private int pagare;

    @Column(nullable = false)
    private int saldo;

    @Column(nullable = false)
    private int pago_minimo;

    @Column(nullable = false)
    private java.sql.Date fecha_proximo_pago;

    @Column(nullable = false)
    private int dias_mora;



    public Cuenta() {
    }

    public Cuenta(String documento, int saldo, int pago_minimo, java.sql.Date fecha_proximo_pago, int dias_mora) {
        this.documento = documento;
        this.saldo = saldo;
        this.pago_minimo = pago_minimo;
        this.fecha_proximo_pago = fecha_proximo_pago;
        this.dias_mora = dias_mora;
    }

    // Getters y setters
    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public int getPagare() {
        return pagare;
    }

    public void setPagare(int pagare) {
        this.pagare = pagare;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public int getPago_minimo() {
        return pago_minimo;
    }

    public void setPago_minimo(int pago_minimo) {
        this.pago_minimo = pago_minimo;
    }

    public Date getFecha_proximo_pago() {
        return fecha_proximo_pago;
    }

    public void setFecha_proximo_pago(java.sql.Date fecha_proximo_pago) {
        this.fecha_proximo_pago = fecha_proximo_pago;
    }

    public int getDias_mora() {
        return dias_mora;
    }

    public void setDias_mora(int dias_mora) {
        this.dias_mora = dias_mora;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }
}
