package com.Racadi.Academy.Racadi_Academy.Controladores;


import com.Racadi.Academy.Racadi_Academy.Entidades.Solicitud;
import com.Racadi.Academy.Racadi_Academy.Servicios.SolicitudServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class SolicitudDocumentoControlador {

    @Autowired
    private SolicitudServicio solicitudServicio;

    @GetMapping("/obtenersolicitudestudiante/{documento}")
    public ResponseEntity<?> obtenerSolicitudesEstudiante(@PathVariable String documento) {
        List<Solicitud> solicitudes = solicitudServicio.obtenerSolicitudesEstudiante(documento);
        if (solicitudes.isEmpty()) {
            return ResponseEntity.badRequest().body("No hay solicitudes para el estudiante.");
        }

        // Mapeo de la lista de solicitudes a un formato de respuesta personalizada
        List<Object> resultados = solicitudes.stream().map(solicitud -> {
            return new Object() {
                public Long id_solicitud = (long) solicitud.getId_solicitud();
                public String documento = String.valueOf(solicitud.getDocumento());
                public String descripcion = solicitud.getDescripcion();
                public String respuesta = solicitud.getRespuesta();
                public String fecha_creacion = solicitud.getFecha_creacion().toString();
            };
        }).collect(Collectors.toList());

        return ResponseEntity.ok(resultados);
    }
}
