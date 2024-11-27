package com.Racadi.Academy.Racadi_Academy.Controladores;

import com.Racadi.Academy.Racadi_Academy.Entidades.Clase;
import com.Racadi.Academy.Racadi_Academy.Entidades.Sede;
import com.Racadi.Academy.Racadi_Academy.Servicios.ClaseServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Clases")
public class ClaseControlador {

    @Autowired
    private ClaseServicio claseServicio;

    @GetMapping
    public ResponseEntity<List<Clase>> listadoClase(){
        List<Clase> lista=claseServicio.listaCLases();
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> crearClase(@RequestBody Clase clase) {

        System.out.println("Nivel recibido: " + clase.getNivel());
        // Verificar si el documento del profesor existe en la base de datos
        if (!claseServicio.existeProfesorPorDocumento(clase.getDocumento_profesor())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("El documento del profesor no existe en la base de datos.");
        }

        // Guardar la clase si el documento del profesor es válido
        Clase guardarClase = claseServicio.agregar(clase);
        return new ResponseEntity<>(guardarClase, HttpStatus.CREATED);
    }

    @GetMapping("/buscar")
    public ResponseEntity<?> obtenerClasesPorSedeYNivel(@RequestParam String sede, @RequestParam String nivel) {
        try {
            // Convertir el String `sede` a un Enum `Sede`
            Sede sedeEnum = Sede.valueOf(sede.trim().toUpperCase());  // Cambio de `toLowerCase` a `toUpperCase` para evitar errores de conversión.

            // Buscar las clases con la sede y nivel proporcionados
            List<Clase> clases = claseServicio.obtenerPorSedeYNivel(sedeEnum, nivel);

            if (clases.isEmpty()) {
                return new ResponseEntity<>("No se encontraron clases para la sede y nivel especificados.", HttpStatus.NOT_FOUND);
            }

            return new ResponseEntity<>(clases, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            // Manejar caso de sede inválida
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("La sede proporcionada no es válida. Valores permitidos: " + List.of(Sede.values()));
        }
    }
}
