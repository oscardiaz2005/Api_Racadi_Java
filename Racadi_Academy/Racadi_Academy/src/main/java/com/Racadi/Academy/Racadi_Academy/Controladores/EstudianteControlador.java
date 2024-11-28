package com.Racadi.Academy.Racadi_Academy.Controladores;

import com.Racadi.Academy.Racadi_Academy.Entidades.Estudiante;
import com.Racadi.Academy.Racadi_Academy.Entidades.Plan;
import com.Racadi.Academy.Racadi_Academy.Repositorios.RepositorioEstudiante;
import com.Racadi.Academy.Racadi_Academy.Repositorios.RepositorioPlan;
import com.Racadi.Academy.Racadi_Academy.Servicios.EstuServicio;
import com.Racadi.Academy.Racadi_Academy.Servicios.PlanServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/Estudiante")
public class EstudianteControlador {

    @Autowired
    private RepositorioPlan repositorioPlan;


    @Autowired
    private RepositorioEstudiante repositorioEstudiante;

    @Autowired
    private EstuServicio estuServicio;

    @Autowired
    private PlanServicio planServicio;


    @PostMapping()
    public ResponseEntity<?> agregarEstudiante(@RequestBody Estudiante estudiante) {
        // Verificar si el plan existe en la base de datos
        Optional<Plan> planOptional = Optional.ofNullable(repositorioPlan.findByNombre(estudiante.getPlan().getNombre()));

        if (planOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("El plan especificado no existe.");
        }

        // Asociar el plan al estudiante
        estudiante.setPlan(planOptional.get());

        // Verificar si el plan no es nulo antes de guardar el estudiante
        if (estudiante.getPlan() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("El campo plan no puede ser nulo.");
        }

        // Guardar el estudiante con el plan
        repositorioEstudiante.save(estudiante);

        return ResponseEntity.ok("Estudiante registrado con éxito.");
    }



    @GetMapping
        public ResponseEntity<List<Estudiante>> listadoEstu(){
            List<Estudiante> lista = estuServicio.listaEstudiantes();
            return new ResponseEntity<>(lista, HttpStatus.OK);
        }


        @PutMapping("/{documento}")
        public ResponseEntity<Estudiante> actualizarEstu(@PathVariable String documento, @RequestBody Estudiante estu){
            try{
                Estudiante actualizado=estuServicio.actualizarEstu(documento,estu);
                return new ResponseEntity<>(actualizado,HttpStatus.OK);
            }catch (RuntimeException e){
                return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
            }
        }


        @DeleteMapping("/{documento}")
        public  ResponseEntity<Void> eliminarEstu(@PathVariable String documento){

            estuServicio.eliminarEstu(documento);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

    @GetMapping("/{documento}")
    public ResponseEntity<?> buscarEstudiantePorDocumento(@PathVariable String documento) {
        // Buscar el estudiante por documento
        Optional<Estudiante> estudianteOptional = repositorioEstudiante.findById(documento);

        // Verificar si el estudiante existe
        if (estudianteOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("El estudiante con documento " + documento + " no fue encontrado.");
        }

        // Retornar el estudiante encontrado
        return ResponseEntity.ok(estudianteOptional.get());
    }
    }

