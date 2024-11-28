package com.Racadi.Academy.Racadi_Academy.Controladores;


import com.Racadi.Academy.Racadi_Academy.Entidades.Plan;
import com.Racadi.Academy.Racadi_Academy.Servicios.PlanServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Planes")
public class PlanControlador {


    @Autowired
    private PlanServicio planServicio;


    @PostMapping
    public ResponseEntity<Plan> crearPlan(@RequestBody Plan plan){
        Plan guardarPlan=planServicio.agregar(plan);
        return new ResponseEntity<>(guardarPlan, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Plan>> listadoPlan(){
        List<Plan> planes= planServicio.listaPlanes();
        return new ResponseEntity<>(planes,HttpStatus.OK);
    }
}
