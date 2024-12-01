package com.Racadi.Academy.Racadi_Academy.Controladores;


import com.Racadi.Academy.Racadi_Academy.Servicios.SolicitudServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EliminarSolicitudControlador {

    @Autowired
    private SolicitudServicio solicitudServicio;

    @DeleteMapping("/eliminar_solicitud/{id}")
    public ResponseEntity<?> eliminarSolicitud(@PathVariable int id) {
        boolean eliminado = solicitudServicio.eliminarSolicitud(id);

        if (eliminado) {
            return ResponseEntity.ok().body("Solicitud con id " + id + " eliminada");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No se encontró solicitud");
        }
    }
}