package com.Racadi.Academy.Racadi_Academy.Controladores;


import com.Racadi.Academy.Racadi_Academy.Entidades.Reserva;
import com.Racadi.Academy.Racadi_Academy.Servicios.ClaseServicio;
import com.Racadi.Academy.Racadi_Academy.Servicios.ReservaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Reserva")
public class ReservaControlador {


    @Autowired
    private ReservaServicio reservaServicio;


    @PostMapping
    public ResponseEntity<Reserva> crearReserva(@RequestBody Reserva reserva){
        Reserva guardarReserva= reservaServicio.agregar(reserva).getBody();
        return new ResponseEntity<>(guardarReserva, HttpStatus.CREATED);
    }
}
