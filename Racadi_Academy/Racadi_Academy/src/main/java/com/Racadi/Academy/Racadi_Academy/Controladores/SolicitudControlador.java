package com.Racadi.Academy.Racadi_Academy.Controladores;


import com.Racadi.Academy.Racadi_Academy.Entidades.Solicitud;
import com.Racadi.Academy.Racadi_Academy.Servicios.SolicitudServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/añadir_Solicitud")
public class SolicitudControlador {

    @Autowired
    private SolicitudServicio solicitudServicio;

    @PostMapping
    public ResponseEntity<String> añadirSolicitud(@RequestBody Solicitud solicitud) {
        try {
            Solicitud nuevaSolicitud = solicitudServicio.añadirSolicitud(solicitud);
            return new ResponseEntity<>("Solicitud fue agregada con éxito", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Algo salió mal: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}