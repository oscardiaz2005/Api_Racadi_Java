package com.Racadi.Academy.Racadi_Academy.Controladores;

import com.Racadi.Academy.Racadi_Academy.Entidades.Nivel;
import com.Racadi.Academy.Racadi_Academy.Servicios.NivelServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class NivelControlador {

    @Autowired
    private NivelServicio nivelServicio;

    @GetMapping("/obtenernombreniveles")
    public ResponseEntity<List<String>> obtenerNombreNiveles() {
        List<String> nombresNiveles = nivelServicio.obtenerNombresNiveles();
        return ResponseEntity.ok(nombresNiveles);
    }

    @PostMapping("/añadir")
    public ResponseEntity<String> agregarNivel(@RequestBody Nivel nivel) {
        try {
            String respuesta = nivelServicio.agregarNivel(nivel);
            return ResponseEntity.ok(respuesta);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
