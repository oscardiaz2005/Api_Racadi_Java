package com.Racadi.Academy.Racadi_Academy.Controladores;


import com.Racadi.Academy.Racadi_Academy.Entidades.Comunicado;
import com.Racadi.Academy.Racadi_Academy.Servicios.ComunicadoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comunicados")
public class ComunicadoControlador {

        private final ComunicadoServicio comunicadoServicio;

        @Autowired
        public ComunicadoControlador(ComunicadoServicio comunicadoServicio) {
            this.comunicadoServicio = comunicadoServicio;
        }

        @PutMapping("/{idComunicado}")
        public ResponseEntity<Comunicado> editarComunicado(
                @PathVariable int idComunicado,
                @RequestParam(required = false) String titulo,
                @RequestParam(required = false) String descripcion,
                @RequestParam(required = false) String foto) {

            Comunicado actualizado = comunicadoServicio.actualizarComunicado(idComunicado, titulo, descripcion, foto);
            return ResponseEntity.ok(actualizado);
        }

    @DeleteMapping("/{idComunicado}")
    public ResponseEntity<String> eliminarComunicado(@PathVariable Long idComunicado) {
        try {
            comunicadoServicio.eliminarComunicado(idComunicado);
            return ResponseEntity.ok("Comunicado eliminado.");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error interno del servidor.");
        }
    }


    @PutMapping("/{idComunicado}")
    public ResponseEntity<?> editarComunicado(
            @PathVariable Long idComunicado,
            @RequestParam(required = false) String titulo,
            @RequestParam(required = false) String descripcion,
            @RequestParam(required = false) String foto) {

        try {
            Comunicado comunicado = comunicadoServicio.editarComunicado(idComunicado, titulo, descripcion, foto);
            return ResponseEntity.ok(comunicado);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error interno del servidor.");
        }
    }
    }

