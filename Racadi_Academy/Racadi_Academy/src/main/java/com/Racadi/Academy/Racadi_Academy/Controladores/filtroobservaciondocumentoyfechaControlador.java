package com.Racadi.Academy.Racadi_Academy.Controladores;

import com.Racadi.Academy.Racadi_Academy.Entidades.Observacion;
import com.Racadi.Academy.Racadi_Academy.Servicios.ObservacionServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class filtroobservaciondocumentoyfechaControlador {

    @Autowired
    private ObservacionServicio observacionServicio;

    @GetMapping("/filtro_ObservadoresFecha/{documento}/{fecha}")
    public ResponseEntity<List<Observacion>> filtroObservacionesPorDocumentoYFecha(
            @PathVariable String documento,
            @PathVariable String fecha) {
        List<Observacion> observaciones = observacionServicio.obtenerObservacionesPorDocumentoYFecha(documento, fecha);
        if (observaciones.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(observaciones);
    }
}