package com.Racadi.Academy.Racadi_Academy.Servicios;


import com.Racadi.Academy.Racadi_Academy.Entidades.Profesores;
import com.Racadi.Academy.Racadi_Academy.Repositorios.RepositorioProfesor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfeServicio {

    @Autowired
    private RepositorioProfesor repositorioProfesor;

    public Profesores agregar(Profesores profe){
        return repositorioProfesor.save(profe);
    }


    public List<Profesores> listaProfesores(){
        return repositorioProfesor.findAll();
    }

    public List<Profesores> buscarPorNombre(String nombre) {
        return repositorioProfesor.findByNombreContainingIgnoreCase(nombre);
    }

    //Metodo para actualizar un administrador
    public Profesores actualizarProfe(String documento, Profesores profe){
        return repositorioProfesor.findById(documento).map(profesorExistente -> {
            profesorExistente.setNombre(profe.getNombre());
            profesorExistente.setApellido(profe.getApellido());
            profesorExistente.setFecha_nacimiento(profe.getFecha_nacimiento());
            profesorExistente.setGenero(profe.getGenero());
            profesorExistente.setCelular(profe.getCelular());
            profesorExistente.setCorreo(profe.getCorreo());
            profesorExistente.setDireccion(profe.getDireccion());
            profesorExistente.setUsuario(profe.getUsuario());
            profesorExistente.setContrasena(profe.getContrasena());
            profesorExistente.setFoto_perfil(profe.getFoto_perfil());
            return repositorioProfesor.save(profesorExistente);
        }).orElseThrow(() -> new RuntimeException("Profesor no encontrado con documento: " + documento));
    }


    public void eliminarProfe(String documento){
        repositorioProfesor.deleteById(documento);
    }
}
