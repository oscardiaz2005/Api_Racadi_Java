package com.Racadi.Academy.Racadi_Academy.Controladores;


import com.Racadi.Academy.Racadi_Academy.Entidades.Nivel;
import com.Racadi.Academy.Racadi_Academy.Servicios.NivelServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Niveles")
public class NivelControlador {


    @Autowired
    private NivelServicio nivelServicio;


    @PostMapping
    public ResponseEntity<Nivel> crearNivel(@RequestBody Nivel nivel){
        Nivel guardarNivel= nivelServicio.agregar(nivel);
        return new ResponseEntity<>(guardarNivel, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Nivel>> listaNiveles(){
        List<Nivel> lista = nivelServicio.listaNiveles();
        return new ResponseEntity<>(lista,HttpStatus.OK);
    }
}
