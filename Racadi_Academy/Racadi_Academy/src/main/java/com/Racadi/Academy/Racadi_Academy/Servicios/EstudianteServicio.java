package com.Racadi.Academy.Racadi_Academy.Servicios;

import com.Racadi.Academy.Racadi_Academy.Entidades.*;
import com.Racadi.Academy.Racadi_Academy.Repositorios.CuentaRepositorio;
import com.Racadi.Academy.Racadi_Academy.Repositorios.EstudianteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class EstudianteServicio {

    @Autowired
    private EstudianteRepositorio estudianteRepositorio;

    @Autowired
    private CuentaRepositorio cuentaRepositorio;

    public boolean usuarioExisteGlobalmente(String usuario) {
        // Verificar si el usuario ya existe en Estudiante
        Estudiante estudiante = estudianteRepositorio.findByUsuario(usuario);
        return estudiante != null;
    }

    public boolean verificarContraseña(String contraseña) {
        String regex = "^(?=.*[0-9])(?=.*[A-Z])(?=.*[@#$%^&+=!]).{8,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(contraseña);
        return matcher.matches();
    }

    public boolean verificarCelular(String celular) {
        return celular.length() == 10;
    }

    public Estudiante crearEstudiante(String documento, String tipoDeDocumento, String nombre, String apellido,
                                      Date fechaNacimiento, Genero genero, String celular, String correo,
                                      String direccion, Sede sede, String usuario, String contraseña,
                                      String nivelActual, String plan, String fotoPerfil) {
        Estudiante estudiante = new Estudiante();
        estudiante.setDocumento(documento);
        estudiante.setTipo_de_documento(tipoDeDocumento);
        estudiante.setNombre(nombre);
        estudiante.setApellido(apellido);
        estudiante.setFecha_nacimiento(fechaNacimiento);
        estudiante.setGenero(genero);
        estudiante.setCelular(celular);
        estudiante.setCorreo(correo);
        estudiante.setDireccion(direccion);
        estudiante.setSede(sede);
        estudiante.setUsuario(usuario);
        estudiante.setContraseña(contraseña);  // Se debe encriptar antes de guardar
        estudiante.setNivel_actual(nivelActual);
        estudiante.setPlan(plan);
        estudiante.setFoto_perfil(fotoPerfil);

        // Guardar estudiante
        Estudiante nuevoEstudiante = estudianteRepositorio.save(estudiante);

        // Crear cuenta asociada al estudiante
        try {
            Cuenta cuenta = new Cuenta();
            cuenta.setDocumento(documento);
            cuenta.setSaldo(obtenerSaldo(plan));
            cuenta.setPago_minimo(obtenerPagoMinimo(plan));
            cuenta.setFecha_proximo_pago(obtenerFechaProximoPago());

            cuentaRepositorio.save(cuenta);
        } catch (Exception e) {
            System.err.println("Error al guardar la cuenta: " + e.getMessage());
            e.printStackTrace();
            throw new RuntimeException("Error al crear la cuenta: " + e.getMessage());
        }

        return nuevoEstudiante;

    }

    public Estudiante findByDocumento(String documento) {
        return estudianteRepositorio.findByDocumento(documento); // Aquí se utiliza el método del repositorio
    }

    public int obtenerSaldo(String plan) {
        // Lógica para obtener el saldo según el plan
        return 1000; // Ejemplo, este valor debería consultarse de la base de datos o ser dinámico
    }

    public int obtenerPagoMinimo(String plan) {
        // Lógica para obtener el pago mínimo según el plan
        return 100; // Ejemplo, este valor debería consultarse de la base de datos o ser dinámico
    }

    public Date obtenerFechaProximoPago() {
        // Lógica para obtener la fecha de próximo pago (ejemplo: un mes después de la fecha actual)
        return Date.valueOf("2025-12-01");
    }
}

