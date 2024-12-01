package com.Racadi.Academy.Racadi_Academy.Servicios;


import com.Racadi.Academy.Racadi_Academy.Entidades.Solicitud;
import com.Racadi.Academy.Racadi_Academy.Repositorios.SolicitudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SolicitudServicio {

    @Autowired
    private SolicitudRepository solicitudRepository;

    public Solicitud añadirSolicitud(Solicitud solicitud) {
        try {
            return solicitudRepository.save(solicitud);
        } catch (Exception e) {
            throw new RuntimeException("Error al agregar la solicitud: " + e.getMessage(), e);
        }
    }

    public List<Solicitud> obtenerSolicitudesEstudiante(String documento) {
        return solicitudRepository.findByDocumentoAndContestacionTrue(documento);
    }

    public List<Solicitud> obtenerTodasSolicitudes() {
        return solicitudRepository.findAll();
    }

    public List<Solicitud> obtenerSolicitudesPorDocumento(String documento) {
        return solicitudRepository.findByDocumentoAndContestacionFalse(documento);
    }

    public boolean eliminarSolicitud(int id) {
        Optional<Solicitud> solicitud = solicitudRepository.findById((long) id);
        if (solicitud.isPresent()) {
            solicitudRepository.delete(solicitud.get());
            return true;
        }
        return false;
    }

    public Solicitud actualizarSolicitud(Long id, Solicitud solicitudActualizada) {
        Optional<Solicitud> solicitudExistente = solicitudRepository.findById(id);

        if (solicitudExistente.isEmpty()) {
            throw new IllegalArgumentException("Solicitud no encontrada.");
        }

        Solicitud solicitud = solicitudExistente.get();
        solicitud.setDescripcion(solicitudActualizada.getDescripcion());
        solicitud.setRespuesta(solicitudActualizada.getRespuesta());
        solicitud.setContestacion(solicitudActualizada.isContestacion());

        return solicitudRepository.save(solicitud);
    }


    public Solicitud actualizarContestacion(Long idSolicitud, String documento, String respuesta) {
        Optional<Solicitud> solicitudOptional = solicitudRepository.findById(idSolicitud);

        if (solicitudOptional.isEmpty()) {
            throw new IllegalArgumentException("Solicitud no encontrada.");
        }

        Solicitud solicitud = solicitudOptional.get();
        solicitud.setContestacion(true); // Actualizar el campo contestación
        solicitud.setRespuesta(respuesta);
        solicitud.setDocumento(documento);

        return solicitudRepository.save(solicitud); // Guardar cambios en la base de datos
    }
}