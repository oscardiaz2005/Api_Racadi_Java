package com.Racadi.Academy.Racadi_Academy.Servicios;

import com.Racadi.Academy.Racadi_Academy.Entidades.Plan;
import com.Racadi.Academy.Racadi_Academy.Repositorios.PlanRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlanServicio {

    @Autowired
    private PlanRepositorio planRepositorio;

    // Método para obtener los nombres de los planes
    public List<String> obtenerNombrePlanes() {
        List<Plan> planes = planRepositorio.findAll();
        // Extraemos solo los nombres de los planes
        return planes.stream().map(Plan::getNombre).collect(Collectors.toList());
    }


    public String agregarPlan(Plan plan) {
        try {
            planRepositorio.save(plan);
            return "Plan agregado correctamente";
        } catch (Exception e) {
            throw new RuntimeException("Algo salió mal: " + e.getMessage());
        }
    }
}
