package com.Racadi.Academy.Racadi_Academy.Servicios;


import com.Racadi.Academy.Racadi_Academy.DTOS.ObservacionDTO;
import com.Racadi.Academy.Racadi_Academy.Entidades.Observacion;
import com.Racadi.Academy.Racadi_Academy.Repositorios.RepositorioObservacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ObservacionServicio {


    @Autowired
    private RepositorioObservacion repositorioObservacion;

    // Agregar Administradores
    public Observacion agregar(Observacion observacion){
        return repositorioObservacion.save(observacion);
    }


    //Muestra los administradores agregados
    public List<Observacion> listaObservaciones(){
        return repositorioObservacion.findAll();
    }



    //Muestra la lista de observaciones, tenioendo en cuenta el estudiante
    public List<ObservacionDTO> listaObservacionesDTO() {
        return repositorioObservacion.findAll()
                .stream()
                .map(obs -> new ObservacionDTO(
                        obs.getFecha(),
                        obs.getDescripcion(),
                        obs.getCreada_por(),
                        obs.getEstudiante() != null ? obs.getEstudiante().getDocumento() : null // Manejar el caso de null
                ))
                .collect(Collectors.toList());
    }


    public List<Observacion> obtenerPorDocumento(String documento) {
        return repositorioObservacion.findByEstudianteDocumento(documento);
    }


}
