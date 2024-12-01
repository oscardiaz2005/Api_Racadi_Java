package com.Racadi.Academy.Racadi_Academy.Servicios;


import com.Racadi.Academy.Racadi_Academy.Entidades.Observacion;
import com.Racadi.Academy.Racadi_Academy.Repositorios.ObservacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObservacionServicio {

    @Autowired
    private ObservacionRepository observacionRepository;

    public Observacion añadirObservacion(Observacion observacion) {
        try {
            return observacionRepository.save(observacion);
        } catch (Exception e) {
            throw new RuntimeException("Error al agregar la observación: " + e.getMessage(), e);
        }
    }


    public List<Observacion> obtenerObservacionesPorDocumento(String documento) {
        return observacionRepository.findByDocumento(documento);
    }

    public List<Observacion> obtenerObservacionesPorDocumentoYFecha(String documento, String fecha) {
        return observacionRepository.findByDocumentoAndFecha(documento, fecha);
    }
}