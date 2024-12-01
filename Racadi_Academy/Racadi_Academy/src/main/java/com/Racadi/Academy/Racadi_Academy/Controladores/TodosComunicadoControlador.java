package com.Racadi.Academy.Racadi_Academy.Controladores;


import com.Racadi.Academy.Racadi_Academy.Entidades.Comunicado;
import com.Racadi.Academy.Racadi_Academy.Servicios.ComunicadoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TodosComunicadoControlador {

    @Autowired
    private ComunicadoServicio comunicadoServicio;

    @GetMapping("/todos_comunicados/")
    public ResponseEntity<?> obtenerComunicados() {
        List<Comunicado> comunicados = comunicadoServicio.obtenerTodosLosComunicados();

        if (!comunicados.isEmpty()) {
            return ResponseEntity.ok(comunicados);
        } else {
            return ResponseEntity.status(404).body("No hay comunicados");
        }
    }
}
