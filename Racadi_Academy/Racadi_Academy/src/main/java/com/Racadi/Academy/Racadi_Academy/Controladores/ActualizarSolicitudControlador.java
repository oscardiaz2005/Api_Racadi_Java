package com.Racadi.Academy.Racadi_Academy.Controladores;


import com.Racadi.Academy.Racadi_Academy.Entidades.Solicitud;
import com.Racadi.Academy.Racadi_Academy.Servicios.SolicitudServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/solicitudes")
public class ActualizarSolicitudControlador {

    @Autowired
    private SolicitudServicio solicitudServicio;

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<String> actualizarSolicitud(@PathVariable Long id, @RequestBody Solicitud solicitud) {
        try {
            solicitudServicio.actualizarSolicitud(id, solicitud);
            return ResponseEntity.ok("Solicitud actualizada con éxito.");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error interno del servidor.");
        }
    }
}
