package com.Racadi.Academy.Racadi_Academy.Controladores;

import com.Racadi.Academy.Racadi_Academy.Entidades.Clase;
import com.Racadi.Academy.Racadi_Academy.Servicios.ClaseServicio;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/clases")
public class ClaseControlador {

    @Autowired
    private ClaseServicio claseServicio;

    @PersistenceContext
    private EntityManager entityManager;

    @GetMapping("/obtenerclasesestudiante/{sede}/{nivel}")
    public ResponseEntity<?> obtenerClasesEstudiante(@PathVariable String sede, @PathVariable String nivel) {
        try {
            List<Clase> clasesEstudiante = claseServicio.obtenerClasesEstudiante(sede, nivel);

            if (clasesEstudiante.isEmpty()) {
                return ResponseEntity.badRequest().body("No Hay Clases Para la Sede " + sede + " y nivel " + nivel + " esta semana");
            }

            List<Object> resultados = clasesEstudiante.stream().map(clase -> {
                return new Object() {
                    public final Long idClase = (long) clase.getId_clase();
                    public final String sede = String.valueOf(clase.getSede());
                    public final String nivel = clase.getNivel();
                    public final String horaInicio = String.valueOf(clase.getHora_inicio());
                    public final String horaFin = String.valueOf(clase.getHora_fin());
                    public final String fecha = String.valueOf(clase.getFecha());
                    public final String profesor = getNameTeacherByDni(clase.getDocumentoProfesor());
                    public final int cupos = clase.getCupos();
                };
            }).collect(Collectors.toList());

            return ResponseEntity.ok(resultados);
        } catch (Exception e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }

    private String getNameTeacherByDni(String dni) {
        // Implementación ficticia para obtener el nombre del profesor por DNI
        // Aquí se debe agregar la lógica de búsqueda del profesor en la base de datos.
        return "Nombre del Profesor"; // Placeholder
    }


}