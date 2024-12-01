package com.Racadi.Academy.Racadi_Academy.Servicios;

import com.Racadi.Academy.Racadi_Academy.Entidades.Profesor;
import com.Racadi.Academy.Racadi_Academy.Repositorios.ProfesorRepositorio;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProfesorServicio {

    @Autowired
    private ProfesorRepositorio profesorRepository;


    public List<Profesor> obtenerTodosLosProfesores() {
        return profesorRepository.findAll();
    }

    public List<Profesor> buscarProfesoresPorNombre(String nombre) {
        return profesorRepository.findByNombreContainingIgnoreCaseOrApellidoContainingIgnoreCase(nombre, nombre);
    }
}
