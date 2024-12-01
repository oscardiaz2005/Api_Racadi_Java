package com.Racadi.Academy.Racadi_Academy.Controladores;

import com.Racadi.Academy.Racadi_Academy.Entidades.Cuenta;
import com.Racadi.Academy.Racadi_Academy.Servicios.CuentaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Date;

@RestController
public class CuentaControlador {

    @Autowired
    private CuentaServicio cuentaServicio;

    @GetMapping("/datos_cuenta")
    public ResponseEntity<?> obtenerCuenta(@RequestParam String documento) {
        Cuenta cuenta = cuentaServicio.obtenerCuentaPorDocumento(documento);
        if (cuenta == null) {
            return ResponseEntity.badRequest().body("No se encontraron datos para el documento proporcionado.");
        }

        // Mapeo de los datos de la cuenta a un formato de respuesta
        return ResponseEntity.ok().body(
                new Object() {
                    public String pagare = String.valueOf(cuenta.getPagare());
                    public String documento = cuenta.getDocumento();
                    public BigDecimal saldo = BigDecimal.valueOf(cuenta.getSaldo());
                    public BigDecimal pagoMinimo = BigDecimal.valueOf(cuenta.getPago_minimo());
                    public Date fechaProximoPago = cuenta.getFecha_proximo_pago();
                    public int diasMora = cuenta.getDias_mora();
                }
        );
    }
}