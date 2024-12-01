package com.Racadi.Academy.Racadi_Academy.Servicios;


import com.Racadi.Academy.Racadi_Academy.Entidades.Administrador;
import com.Racadi.Academy.Racadi_Academy.Repositorios.AdministradorRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AdministradorServicio {

    @Autowired
    private AdministradorRepositorio administradorRepositorio;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public String agregarAdministrador(Administrador administrador) {
        // Verificar si el ID ya existe
        if (administradorRepositorio.findByAdministradorId(administrador.getAdministrador_id()).isPresent()) {
            throw new RuntimeException("El id de administrador '" + administrador.getAdministrador_id() + "' ya está en uso");
        }

        // Verificar si el usuario ya existe
        if (administradorRepositorio.findByUsuario(administrador.getUsuario()).isPresent()) {
            throw new RuntimeException("El usuario '" + administrador.getUsuario() + "' ya está en uso");
        }

        // Verificar contraseña (mínimo 8 caracteres, al menos un número, un carácter especial y una mayúscula)
        if (!verificarContraseña(administrador.getContraseña())) {
            throw new RuntimeException("La contraseña debe tener al menos 8 caracteres, incluyendo números, caracteres especiales y mayúsculas");
        }

        // Encriptar contraseña
        administrador.setContraseña(passwordEncoder.encode(administrador.getContraseña()));

        try {
            administradorRepositorio.save(administrador);
            return "Administrador agregado exitosamente";
        } catch (Exception e) {
            throw new RuntimeException("Algo salió mal: " + e.getMessage());
        }
    }

    private boolean verificarContraseña(String contraseña) {
        // Expresión regular para verificar la contraseña
        String regex = "^(?=.*[0-9])(?=.*[!@#$%^&*(),.?\":{}|<>])(?=.*[A-Z]).{8,}$";
        return contraseña.matches(regex);
    }
}