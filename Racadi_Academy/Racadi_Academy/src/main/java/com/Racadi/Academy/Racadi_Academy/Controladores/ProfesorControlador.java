package com.Racadi.Academy.Racadi_Academy.Controladores;


import com.Racadi.Academy.Racadi_Academy.Entidades.Profesores;
import com.Racadi.Academy.Racadi_Academy.Servicios.ProfeServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Profesor")
public class ProfesorControlador {


    @Autowired
    private ProfeServicio profeServicio;


    @PostMapping
    public ResponseEntity<Profesores> crearProfesor(@RequestBody Profesores profe){
        Profesores guardarProfe=profeServicio.agregar(profe);
        return new ResponseEntity<>(guardarProfe, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Profesores>> listadoProfes(){
        List<Profesores> lista = profeServicio.listaProfesores();
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<Profesores>> buscarProfesorPorNombre(@RequestParam String nombre) {
        List<Profesores> profesores = profeServicio.buscarPorNombre(nombre);
        return new ResponseEntity<>(profesores, HttpStatus.OK);
    }

    @PutMapping("/{documento}")
    public ResponseEntity<Profesores> actualizarProfe(@PathVariable String documento, @RequestBody Profesores profe){
        try{
            Profesores actualizado=profeServicio.actualizarProfe(documento,profe);
            return new ResponseEntity<>(actualizado,HttpStatus.OK);
        }catch (RuntimeException e){
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
    }


    @DeleteMapping("/{documento}")
    public  ResponseEntity<Void> eliminarProfe(@PathVariable String documento){

        profeServicio.eliminarProfe(documento);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
