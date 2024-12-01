package com.Racadi.Academy.Racadi_Academy.Controladores;


import com.Racadi.Academy.Racadi_Academy.Servicios.ClaseServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CancelarClaseControlador {

    @Autowired
    private ClaseServicio claseServicio;

    @DeleteMapping("/cancelar_reserva")
    public ResponseEntity<?> cancelarReserva(@RequestParam Long idClase, @RequestParam String documentoEstudiante) {
        try {
            String mensaje = claseServicio.cancelarReserva(idClase, documentoEstudiante);
            return ResponseEntity.ok(mensaje);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error interno del servidor: " + e.getMessage());
        }
    }
}