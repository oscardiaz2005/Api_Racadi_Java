package com.Racadi.Academy.Racadi_Academy.Controladores;


import com.Racadi.Academy.Racadi_Academy.Entidades.Solicitud;
import com.Racadi.Academy.Racadi_Academy.Servicios.SolicitudServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class DatosSolicitudControlador {

    @Autowired
    private SolicitudServicio solicitudServicio;

    @GetMapping("/traer_datos_solicitudes/{documento}")
    public ResponseEntity<?> obtenerSolicitudes(@PathVariable String documento) {
        List<Solicitud> solicitudesEstudiante = solicitudServicio.obtenerSolicitudesPorDocumento(documento);

        if (!solicitudesEstudiante.isEmpty()) {
            List<Object> resultados = solicitudesEstudiante.stream().map(solicitud -> {
                return Map.of(
                        "id_solicitud", solicitud.getId_solicitud(),
                        "descripcion", solicitud.getDescripcion(),
                        "respuesta", solicitud.getRespuesta(),
                        "fecha_creacion", solicitud.getFecha_creacion()
                );
            }).collect(Collectors.toList());

            return ResponseEntity.ok(resultados);
        } else {
            return ResponseEntity.status(400).body("No hay solicitudes para el estudiante.");
        }
    }
}
