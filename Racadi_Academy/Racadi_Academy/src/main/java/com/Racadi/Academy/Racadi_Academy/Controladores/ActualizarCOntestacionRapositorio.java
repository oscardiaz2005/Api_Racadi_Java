package com.Racadi.Academy.Racadi_Academy.Controladores;

import com.Racadi.Academy.Racadi_Academy.Servicios.SolicitudServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/solicitudes")
public class ActualizarCOntestacionRapositorio {

    @Autowired
    private SolicitudServicio solicitudServicio;

    @PutMapping("/actualizar_contestacion/{idSolicitud}/{documento}/{respuesta}")
    public ResponseEntity<String> actualizarContestacion(
            @PathVariable Long idSolicitud,
            @PathVariable String documento,
            @PathVariable String respuesta) {

        try {
            solicitudServicio.actualizarContestacion(idSolicitud, documento, respuesta);
            return ResponseEntity.ok("Contestación actualizada con éxito.");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error interno del servidor.");
        }
    }
}