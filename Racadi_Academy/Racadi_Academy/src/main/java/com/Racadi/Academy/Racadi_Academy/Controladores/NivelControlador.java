package com.Racadi.Academy.Racadi_Academy.Controladores;

import com.Racadi.Academy.Racadi_Academy.Servicios.NivelServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
