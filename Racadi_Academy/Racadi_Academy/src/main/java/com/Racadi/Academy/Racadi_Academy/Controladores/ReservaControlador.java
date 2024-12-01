package com.Racadi.Academy.Racadi_Academy.Controladores;

import com.Racadi.Academy.Racadi_Academy.Entidades.Reserva;
import com.Racadi.Academy.Racadi_Academy.Servicios.ReservaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ReservaControlador {

    @Autowired
    private ReservaServicio reservaServicio;

    @GetMapping("/obtener_reservas/{documento_estudiante}")
    public ResponseEntity<List<Reserva>> obtenerReservas(@PathVariable String documento_estudiante) {
        List<Reserva> reservas = reservaServicio.obtenerReservasPorDocumento(documento_estudiante);
        if (reservas.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(reservas);
    }
}