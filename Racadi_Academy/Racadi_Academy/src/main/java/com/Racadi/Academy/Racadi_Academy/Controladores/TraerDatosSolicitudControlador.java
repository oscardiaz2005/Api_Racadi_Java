package com.Racadi.Academy.Racadi_Academy.Controladores;


import com.Racadi.Academy.Racadi_Academy.Entidades.Solicitud;
import com.Racadi.Academy.Racadi_Academy.Servicios.SolicitudServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TraerDatosSolicitudControlador {

    @Autowired
    private SolicitudServicio solicitudServicio;

    @GetMapping("/traer_datos_solicitudes")
    public ResponseEntity<?> obtenerSolicitudes() {
        List<Solicitud> infoSolicitudes = solicitudServicio.obtenerTodasSolicitudes();
        if (!infoSolicitudes.isEmpty()) {
            return ResponseEntity.ok(infoSolicitudes);
        } else {
            return ResponseEntity.ok().body("No hay solicitudes");
        }
    }
}