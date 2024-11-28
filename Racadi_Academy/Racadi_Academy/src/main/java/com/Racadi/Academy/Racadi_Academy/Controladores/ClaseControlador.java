package com.Racadi.Academy.Racadi_Academy.Controladores;

import com.Racadi.Academy.Racadi_Academy.Entidades.Clase;
import com.Racadi.Academy.Racadi_Academy.Entidades.Sede;
import com.Racadi.Academy.Racadi_Academy.Servicios.ClaseServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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

    @GetMapping("/obtenerclasesestudiante/{sede}/{nivel}")
    public ResponseEntity<?> obtenerClasesEstudiante(@PathVariable String sede, @PathVariable String nivel) {
        try {
            // Validar y convertir la sede al Enum correspondiente
            Sede sedeEnum = Sede.valueOf(sede.trim().toLowerCase());

            // Obtener las clases con los detalles requeridos
            List<Map<String, Object>> clases = claseServicio.obtenerClasesConDetalles(sedeEnum, nivel);

            // Verificar si hay resultados
            if (clases.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("No Hay Clases Para la Sede " + sede + " y nivel " + nivel + " esta semana");
            }

            return new ResponseEntity<>(clases, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            // Manejar caso de sede inválida
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("La sede proporcionada no es válida. Valores permitidos: " + List.of(Sede.values()));
        } catch (Exception e) {
            // Manejar errores generales
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

}
