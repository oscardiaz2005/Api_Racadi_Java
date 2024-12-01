package com.Racadi.Academy.Racadi_Academy.Controladores;

import com.Racadi.Academy.Racadi_Academy.Entidades.Plan;
import com.Racadi.Academy.Racadi_Academy.Servicios.PlanServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class PlanControlador {

    @Autowired
    private PlanServicio planServicio;

    @GetMapping("/obtenernombreplanes")
    public ResponseEntity<List<String>> obtenerNombrePlanes() {
        try {
            List<String> nombresPlanes = planServicio.obtenerNombrePlanes();
            return ResponseEntity.ok(nombresPlanes);
        } catch (Exception e) {
            return ResponseEntity.status(400).body(null);
        }
    }

    @PostMapping("/añadir")
    public ResponseEntity<String> agregarPlan(@RequestBody Plan plan) {
        try {
            String respuesta = planServicio.agregarPlan(plan);
            return ResponseEntity.ok(respuesta);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
