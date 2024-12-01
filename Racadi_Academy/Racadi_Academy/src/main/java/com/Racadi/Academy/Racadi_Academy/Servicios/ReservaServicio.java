package com.Racadi.Academy.Racadi_Academy.Servicios;

import com.Racadi.Academy.Racadi_Academy.Entidades.Reserva;
import com.Racadi.Academy.Racadi_Academy.Repositorios.ReservaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservaServicio {

    @Autowired
    private ReservaRepositorio reservaRepositorio;

    public List<Reserva> obtenerReservasPorDocumento(String documentoEstudiante) {
        return reservaRepositorio.findByDocumentoEstudiante(documentoEstudiante);
    }
}