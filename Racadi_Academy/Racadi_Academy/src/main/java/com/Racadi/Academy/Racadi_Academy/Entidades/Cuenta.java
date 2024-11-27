package com.Racadi.Academy.Racadi_Academy.Entidades;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
public class Cuenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long pagare;

    @Column(nullable = false)
    private long saldo;

    @Column(nullable = false)
    private long saldo_minimo;

    @Column(nullable = false)
    private Date fecha_proximo_pago;

    @Column(nullable = false)
    private long dias_mora;

    @ManyToOne(targetEntity = Estudiantes.class)
    private Estudiantes documento_cuenta;

    @OneToMany(targetEntity = Pago.class, fetch = FetchType.LAZY, mappedBy = "cuenta_documento")
    private List<Pago> cuenta;





    public Cuenta (){}

    public Cuenta(long pagare, long saldo, long saldo_minimo, Date fecha_proximo_pago, long dias_mora, Estudiantes documento_cuenta) {
        this.pagare = pagare;
        this.saldo = saldo;
        this.saldo_minimo = saldo_minimo;
        this.fecha_proximo_pago = fecha_proximo_pago;
        this.dias_mora = dias_mora;
        this.documento_cuenta = documento_cuenta;
    }

    public long getPagare() {
        return pagare;
    }

    public void setPagare(long pagare) {
        this.pagare = pagare;
    }

    public long getSaldo() {
        return saldo;
    }

    public void setSaldo(long saldo) {
        this.saldo = saldo;
    }

    public long getSaldo_minimo() {
        return saldo_minimo;
    }

    public void setSaldo_minimo(long saldo_minimo) {
        this.saldo_minimo = saldo_minimo;
    }

    public Date getFecha_proximo_pago() {
        return fecha_proximo_pago;
    }

    public void setFecha_proximo_pago(Date fecha_proximo_pago) {
        this.fecha_proximo_pago = fecha_proximo_pago;
    }

    public long getDias_mora() {
        return dias_mora;
    }

    public void setDias_mora(long dias_mora) {
        this.dias_mora = dias_mora;
    }

    public Estudiantes getDocumento_cuenta() {
        return documento_cuenta;
    }

    public void setDocumento_cuenta(Estudiantes documento_cuenta) {
        this.documento_cuenta = documento_cuenta;
    }
}
