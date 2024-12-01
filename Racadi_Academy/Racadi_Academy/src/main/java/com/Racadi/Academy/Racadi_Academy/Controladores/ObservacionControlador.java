package com.Racadi.Academy.Racadi_Academy.Controladores;


import com.Racadi.Academy.Racadi_Academy.Entidades.Observacion;
import com.Racadi.Academy.Racadi_Academy.Servicios.ObservacionServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/añadirObservacion")
public class ObservacionControlador {

    @Autowired
    private ObservacionServicio observacionServicio;

    @PostMapping
    public ResponseEntity<String> añadirObservacion(@RequestBody Observacion observacion) {
        try {
            Observacion nuevaObservacion = observacionServicio.añadirObservacion(observacion);
            return new ResponseEntity<>("Observación fue agregada", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Algo salió mal: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }


}
