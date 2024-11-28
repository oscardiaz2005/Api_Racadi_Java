package com.Racadi.Academy.Racadi_Academy.Servicios;

import com.Racadi.Academy.Racadi_Academy.Entidades.Plan;
import com.Racadi.Academy.Racadi_Academy.Repositorios.RepositorioPlan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanServicio {

    @Autowired
    private RepositorioPlan repositorioPlan;

    public Plan agregar(Plan plan){
        return repositorioPlan.save(plan);
    }

    public List<Plan> listaPlanes(){return repositorioPlan.findAll();
    }

    public Plan buscarPorNombre(String nombre) {
        return repositorioPlan.findByNombre(nombre);
    }

}
