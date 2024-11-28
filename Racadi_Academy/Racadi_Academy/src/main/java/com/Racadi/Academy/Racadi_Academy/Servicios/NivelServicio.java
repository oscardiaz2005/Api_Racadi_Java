package com.Racadi.Academy.Racadi_Academy.Servicios;

import com.Racadi.Academy.Racadi_Academy.Entidades.Nivel;
import com.Racadi.Academy.Racadi_Academy.Repositorios.RepositorioNivel;
import com.Racadi.Academy.Racadi_Academy.Repositorios.RepositorioPlan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class NivelServicio {

    @Autowired
    private RepositorioNivel repositorioNivel;

    public Nivel agregar(Nivel nivel){
        return repositorioNivel.save(nivel);
    }


    public List<Nivel> listaNiveles(){
        return repositorioNivel.findAll();
    }
}
