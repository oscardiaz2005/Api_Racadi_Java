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
@RequestMapping("/Solicitud")
public class SolicitudControlador {
    @Autowired
    private SolicitudServicio solicitudServicio;


    @PostMapping
    public ResponseEntity<Solicitud> crearSolicitud(@RequestBody Solicitud soli){
        Solicitud guardarSoli= solicitudServicio.agregar(soli);
        return new ResponseEntity<>(guardarSoli, HttpStatus.CREATED);
    }
}
