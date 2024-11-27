package com.Racadi.Academy.Racadi_Academy.Servicios;

import com.Racadi.Academy.Racadi_Academy.Entidades.Clase;
import com.Racadi.Academy.Racadi_Academy.Entidades.Sede;
import com.Racadi.Academy.Racadi_Academy.Repositorios.RepositorioClase;
import com.Racadi.Academy.Racadi_Academy.Repositorios.RepositorioProfesor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


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
    public List<Clase> obtenerPorSedeYNivel(Sede sede, String nivel) {
        return repositorioClase.findBySedeAndNivel(sede, nivel);
    }

}
