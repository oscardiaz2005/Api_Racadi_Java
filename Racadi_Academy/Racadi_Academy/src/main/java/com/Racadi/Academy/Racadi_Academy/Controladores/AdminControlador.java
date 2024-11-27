package com.Racadi.Academy.Racadi_Academy.Controladores;

import com.Racadi.Academy.Racadi_Academy.Entidades.Administrador;
import com.Racadi.Academy.Racadi_Academy.Servicios.AdminServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("/Administrador")
public class AdminControlador {

    @Autowired
    private AdminServicio AdminServicio;


    @PostMapping
    public ResponseEntity<Administrador> crearAdmin(@RequestBody Administrador admin) {
        Administrador guardarAdmin = AdminServicio.agregar(admin);
        return new ResponseEntity<>(guardarAdmin, HttpStatus.CREATED);
    }


    @GetMapping
    public ResponseEntity<List<Administrador>> listadoAdmin() {
            List<Administrador> lista = AdminServicio.listaAdministradores();
            return new ResponseEntity<>(lista, HttpStatus.OK);
    }



    // Endpoint para actualizar un administrador
    @PutMapping("/{documento}")
    public ResponseEntity<Administrador> actualizarAdmin(@PathVariable String documento, @RequestBody Administrador admin) {
        try {
            Administrador actualizado = AdminServicio.actualizarAdmin(documento, admin);
            return new ResponseEntity<>(actualizado, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint para eliminar un administrador
    @DeleteMapping("/{documento}")
    public ResponseEntity<Void> eliminarAdmin(@PathVariable String documento) {
        AdminServicio.eliminarAdmin(documento);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
