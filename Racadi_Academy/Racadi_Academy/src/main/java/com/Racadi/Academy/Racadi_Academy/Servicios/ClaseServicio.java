package com.Racadi.Academy.Racadi_Academy.Servicios;

import com.Racadi.Academy.Racadi_Academy.Entidades.Clase;
import com.Racadi.Academy.Racadi_Academy.Entidades.Sede;
import com.Racadi.Academy.Racadi_Academy.Repositorios.RepositorioClase;
import com.Racadi.Academy.Racadi_Academy.Repositorios.RepositorioProfesor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Service
public class ClaseServicio {


    @Autowired
    private RepositorioClase repositorioClase;

    @Autowired
    private RepositorioProfesor repositorioProfesor;


    public boolean existeProfesorPorDocumento(String documentoProfesor) {
        return repositorioProfesor.existsByDocumento(documentoProfesor);
    }

    public List<Clase> listaCLases(){
        return repositorioClase.findAll();
    }

    //Agregar una clase
    public Clase agregar (Clase clase){
        return repositorioClase.save(clase);
    }


    // Método para buscar clases por sede y nivel

    public List<Map<String, Object>> obtenerClasesConDetalles(Sede sede, String nivel) {
        List<Clase> clases = repositorioClase.findBySedeAndNivel(sede, nivel);

        return clases.stream().map(clase -> {
            Map<String, Object> resultado = new HashMap<>();
            resultado.put("id_clase", clase.getId_clase());
            resultado.put("sede", clase.getSede());
            resultado.put("nivel", clase.getNivel());
            resultado.put("hora_inicio", clase.getHora_inicio());
            resultado.put("hora_fin", clase.getHora_fin());
            resultado.put("fecha", clase.getFecha());
            resultado.put("profesor", obtenerNombreProfesor(clase.getDocumento_profesor()));
            resultado.put("cupos", clase.getCupos());
            return resultado;
        }).collect(Collectors.toList());
    }

    // Método para obtener el nombre del profesor basado en el documento
    private String obtenerNombreProfesor(String documentoProfesor) {
        // Este método debe ser implementado en tu RepositorioProfesor
        return repositorioProfesor.findNombreByDocumento(documentoProfesor)
                .orElse("Nombre no encontrado");
    }
}
