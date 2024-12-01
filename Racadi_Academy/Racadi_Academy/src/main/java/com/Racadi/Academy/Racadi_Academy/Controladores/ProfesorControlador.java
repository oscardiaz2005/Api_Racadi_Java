package com.Racadi.Academy.Racadi_Academy.Controladores;

import com.Racadi.Academy.Racadi_Academy.Entidades.Profesor;
import com.Racadi.Academy.Racadi_Academy.Servicios.ProfesorServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/profesores")
public class ProfesorControlador {

    @Autowired
    private ProfesorServicio profesorServicio;

    @GetMapping("/obtenerprofesores")
    public ResponseEntity<List<Profesor>> obtenerTodosLosProfesores() {
        try {
            List<Profesor> profesores = profesorServicio.obtenerTodosLosProfesores();
            return ResponseEntity.ok(profesores);
        } catch (Exception e) {
            return ResponseEntity.status(400).build();
        }
    }


    @GetMapping("/buscarprofesores")
    public ResponseEntity<List<Profesor>> buscarProfesores(@RequestParam String nombre) {
        try {
            List<Profesor> profesores = profesorServicio.buscarProfesoresPorNombre(nombre);
            List<Profesor> resultados = profesores.stream().map(profesor -> {
                return new Profesor(profesor.getDocumento(), profesor.getNombre(), profesor.getApellido());
            }).collect(Collectors.toList());

            return ResponseEntity.ok(resultados);
        } catch (Exception e) {
            return ResponseEntity.status(400).build();
        }
    }
}