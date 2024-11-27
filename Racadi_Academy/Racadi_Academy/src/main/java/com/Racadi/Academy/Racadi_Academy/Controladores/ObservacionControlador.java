package com.Racadi.Academy.Racadi_Academy.Controladores;


import com.Racadi.Academy.Racadi_Academy.DTOS.ObservacionDTO;
import com.Racadi.Academy.Racadi_Academy.Entidades.Estudiantes;
import com.Racadi.Academy.Racadi_Academy.Entidades.Observacion;
import com.Racadi.Academy.Racadi_Academy.Repositorios.RepositorioEstudiante;
import com.Racadi.Academy.Racadi_Academy.Servicios.ObservacionServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/Observaciones")
public class ObservacionControlador {



    @Autowired
    private ObservacionServicio observacionServicio;

    @Autowired
    private RepositorioEstudiante repositorioEstudiante;

    @PostMapping
    public ResponseEntity<Observacion> crearObservacion(@RequestBody Map<String, Object> requestData) {
        // Extraer los campos necesarios del JSON
        String documento = (String) requestData.get("documento");
        String descripcion = (String) requestData.get("descripcion");
        String creadaPor = (String) requestData.get("creada_por");
        Date fecha;

        System.out.println(documento + descripcion + creadaPor);

        try {
            fecha = new SimpleDateFormat("yyyy-MM-dd").parse((String) requestData.get("fecha"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

        // Validar que el documento no sea nulo
        if (documento == null || documento.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null); // Mensaje personalizado opcional
        }



        // Buscar al estudiante en la base de datos
        Estudiantes estudiante = repositorioEstudiante.findByDocumento(documento);
        if (estudiante == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        // Crear y asignar datos a la observación
        Observacion observacion = new Observacion();
        observacion.setDescripcion(descripcion);
        observacion.setCreada_por(creadaPor);
        observacion.setFecha(fecha);

        // Guardar la observación
        Observacion guardarObservacion = observacionServicio.agregar(observacion);

        return ResponseEntity.status(HttpStatus.CREATED).body(guardarObservacion);
    }

    @GetMapping
    public ResponseEntity<List<ObservacionDTO>> listaObservaciones() {
        List<ObservacionDTO> lista = observacionServicio.listaObservacionesDTO();
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @GetMapping("/{documento}")
    public ResponseEntity<Map<String, Object>> obtenerDatosPorDocumento(@PathVariable String documento) {
        // Buscar al estudiante en la base de datos
        Estudiantes estudiante = repositorioEstudiante.findByDocumento(documento);
        if (estudiante == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        // Formatear la fecha para mostrar solo "yyyy-MM-dd"
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        // Crear un mapa con los datos del estudiante y sus observaciones
        Map<String, Object> response = new HashMap<>();
        response.put("documento", estudiante.getDocumento());
        response.put("nombre", estudiante.getNombre());
        response.put("apellido", estudiante.getApellido());

        List<Map<String, Object>> observaciones = observacionServicio.obtenerPorDocumento(documento).stream().map(obs -> {
            Map<String, Object> obsData = new HashMap<>();
            obsData.put("descripcion", obs.getDescripcion());
            obsData.put("creada_por", obs.getCreada_por());
            obsData.put("fecha", formatter.format(obs.getFecha()));
            return obsData;
        }).collect(Collectors.toList());

        response.put("observaciones", observaciones);

        return ResponseEntity.ok(response);
    }
}
