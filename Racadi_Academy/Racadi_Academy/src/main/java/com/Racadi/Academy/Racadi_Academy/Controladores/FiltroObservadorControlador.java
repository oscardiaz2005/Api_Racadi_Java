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
public class FiltroObservadorControlador {

    @Autowired
    private ObservacionServicio observacionServicio;

    @GetMapping("/filtro_ObservadoresDocumento/{documento}")
    public ResponseEntity<List<Observacion>> filtroObservacionesPorDocumento(@PathVariable String documento) {
        List<Observacion> observaciones = observacionServicio.obtenerObservacionesPorDocumento(documento);
        if (observaciones.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(observaciones);
    }
}