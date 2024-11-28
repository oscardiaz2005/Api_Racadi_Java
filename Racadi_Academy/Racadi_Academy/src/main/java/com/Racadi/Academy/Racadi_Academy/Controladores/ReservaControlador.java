package com.Racadi.Academy.Racadi_Academy.Controladores;



import com.Racadi.Academy.Racadi_Academy.Entidades.Reserva;
import com.Racadi.Academy.Racadi_Academy.Servicios.ReservaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Reservas")
public class ReservaControlador {

    @Autowired
    private ReservaServicio reservaServicio;


    @PostMapping
    public ResponseEntity<Reserva> crearReserva(@RequestBody Reserva reserva){
        Reserva guardarReserva=reservaServicio.agregar(reserva);
        return new ResponseEntity<>(guardarReserva, HttpStatus.CREATED);
    }


    @GetMapping("/obtener_reservas/{documento_estudiante}")
    public List<Reserva> obtenerReservas(@PathVariable String documento_estudiante) {
        return reservaServicio.obtenerReservasPorDocumento(documento_estudiante);
    }
}
