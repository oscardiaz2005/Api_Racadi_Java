package com.Racadi.Academy.Racadi_Academy.Entidades;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Pago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_pago;

    @Column(nullable = false)
    private Date fecha;

    @Column(nullable = false)
    private int calor;


    @ManyToOne(targetEntity = Cuenta.class)
    private Cuenta cuenta_documento;



    public Pago(){

    }

    public Pago(long id_pago, Date fecha, int calor, Cuenta cuenta_documento) {
        this.id_pago = id_pago;
        this.fecha = fecha;
        this.calor = calor;
        this.cuenta_documento = cuenta_documento;
    }

    public Cuenta getCuenta_documento() {
        return cuenta_documento;
    }

    public void setCuenta_documento(Cuenta cuenta_documento) {
        this.cuenta_documento = cuenta_documento;
    }

    public long getId_pago() {
        return id_pago;
    }

    public void setId_pago(long id_pago) {
        this.id_pago = id_pago;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getCalor() {
        return calor;
    }

    public void setCalor(int calor) {
        this.calor = calor;
    }


}
