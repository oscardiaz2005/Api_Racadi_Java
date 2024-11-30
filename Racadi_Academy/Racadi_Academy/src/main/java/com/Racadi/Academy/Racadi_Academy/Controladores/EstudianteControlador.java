package com.Racadi.Academy.Racadi_Academy.Controladores;

import com.Racadi.Academy.Racadi_Academy.Entidades.Genero;
import com.Racadi.Academy.Racadi_Academy.Entidades.Plan;
import com.Racadi.Academy.Racadi_Academy.Entidades.Sede;
import com.Racadi.Academy.Racadi_Academy.Servicios.EstudianteServicio;
import com.Racadi.Academy.Racadi_Academy.Entidades.Estudiante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Date;

@RestController
public class EstudianteControlador {

    @Autowired
    private EstudianteServicio estudianteServicio;

    @PostMapping("/anadirestudiante")
    public ResponseEntity<String> añadirEstudiante(@RequestParam String documento,
                                                   @RequestParam String tipo_de_documento,
                                                   @RequestParam String nombre,
                                                   @RequestParam String apellido,
                                                   @RequestParam Date fecha_nacimiento,
                                                   @RequestParam Genero genero,
                                                   @RequestParam String celular,
                                                   @RequestParam String correo,
                                                   @RequestParam String direccion,
                                                   @RequestParam Sede sede,
                                                   @RequestParam String usuario,
                                                   @RequestParam String contraseña,
                                                   @RequestParam String nivel_actual,
                                                   @RequestParam String plan,
                                                   @RequestParam(required = false) MultipartFile file) {

        // Verificar si el documento ya está en uso
        Estudiante existeDocumento = estudianteServicio.findByDocumento(documento);
        if (existeDocumento != null) {
            return ResponseEntity.badRequest().body("El documento ya está en uso.");
        }

        // Verificar si el usuario ya existe
        if (estudianteServicio.usuarioExisteGlobalmente(usuario)) {
            return ResponseEntity.badRequest().body("El usuario ya está en uso.");
        }

        // Verificar si la contraseña es válida
        if (!estudianteServicio.verificarContraseña(contraseña)) {
            return ResponseEntity.badRequest().body("La contraseña debe tener al menos 8 caracteres, incluyendo números, caracteres especiales y mayúsculas.");
        }

        // Verificar si el celular es válido
        if (!estudianteServicio.verificarCelular(celular)) {
            return ResponseEntity.badRequest().body("Número de celular inválido, debe tener 10 dígitos.");
        }

        // Lógica para manejar la foto (opcional)
        String fotoPerfilUrl = null;
        if (file != null && !file.isEmpty()) {
            // Guardar archivo y asignar URL de la imagen
            fotoPerfilUrl = "path/to/folder/" + file.getOriginalFilename(); // Guardar imagen en el servidor
        }

        // Crear el estudiante
        Estudiante nuevoEstudiante = estudianteServicio.crearEstudiante(documento, tipo_de_documento, nombre, apellido,
                fecha_nacimiento, genero, celular, correo, direccion,
                sede, usuario, contraseña, nivel_actual, plan,
                fotoPerfilUrl);

        return ResponseEntity.ok("Estudiante agregado exitosamente.");
    }
}

