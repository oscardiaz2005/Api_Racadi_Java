package com.Racadi.Academy.Racadi_Academy.Servicios;

import com.Racadi.Academy.Racadi_Academy.Entidades.Estudiantes;
import com.Racadi.Academy.Racadi_Academy.Entidades.Reserva;
import com.Racadi.Academy.Racadi_Academy.Repositorios.RepositorioEstudiante;
import com.Racadi.Academy.Racadi_Academy.Repositorios.RepositorioReserva;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReservaServicio {


    @Autowired
    private RepositorioEstudiante repositorioEstudiante;

    @Autowired
    private RepositorioReserva repositorioReserva;



    // Agregar Reserva con verificación de existencia de estudiante
    public ResponseEntity<Reserva> agregar(Reserva reserva) {
        // Verificar si el estudiante existe en la base de datos
        Optional<Estudiantes> estudianteOptional = Optional.ofNullable(repositorioEstudiante.findByDocumento(reserva.getDocumento_estudiante()));

        if (estudianteOptional.isEmpty()) {
            // Si el estudiante no existe, retornar un error
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        // Si el estudiante existe, guardar la reserva
        Reserva reservaGuardada = repositorioReserva.save(reserva);
        return new ResponseEntity<>(reservaGuardada, HttpStatus.CREATED);
    }
}
