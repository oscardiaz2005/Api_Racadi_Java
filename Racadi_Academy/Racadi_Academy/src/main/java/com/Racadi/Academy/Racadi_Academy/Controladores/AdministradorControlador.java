package com.Racadi.Academy.Racadi_Academy.Controladores;


import com.Racadi.Academy.Racadi_Academy.Entidades.Administrador;
import com.Racadi.Academy.Racadi_Academy.Servicios.AdministradorServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/administradores")
public class AdministradorControlador {

    @Autowired
    private AdministradorServicio administradorServicio;

    @PostMapping("/añadir")
    public ResponseEntity<String> agregarAdministrador(@RequestBody Administrador administrador) {
        try {
            String respuesta = administradorServicio.agregarAdministrador(administrador);
            return ResponseEntity.ok(respuesta);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}