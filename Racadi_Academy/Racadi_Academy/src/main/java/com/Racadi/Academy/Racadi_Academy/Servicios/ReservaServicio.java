package com.Racadi.Academy.Racadi_Academy.Servicios;

import com.Racadi.Academy.Racadi_Academy.Entidades.Reserva;
import com.Racadi.Academy.Racadi_Academy.Repositorios.RepositorioReserva;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservaServicio {


    @Autowired
    private RepositorioReserva repositorioReserva;


    public Reserva agregar (Reserva reserva){
        return repositorioReserva.save(reserva);
    }

    public List<Reserva> obtenerReservasPorDocumento(String documento_estudiante) {
        return repositorioReserva.findByDocumento_estudiante(documento_estudiante);
    }
}
