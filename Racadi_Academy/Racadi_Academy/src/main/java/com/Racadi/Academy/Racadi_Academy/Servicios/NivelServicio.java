package com.Racadi.Academy.Racadi_Academy.Servicios;

import com.Racadi.Academy.Racadi_Academy.Entidades.Nivel;
import com.Racadi.Academy.Racadi_Academy.Repositorios.NivelRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NivelServicio {

    @Autowired
    private NivelRepositorio nivelRepositorio;

    public List<String> obtenerNombresNiveles() {
        List<Nivel> niveles = nivelRepositorio.findAll(); // Obtener todos los niveles
        return niveles.stream()
                .map(Nivel::getNombre_nivel) // E
                .collect(Collectors.toList());
    }


    public String agregarNivel(Nivel nivel) {
        try {
            nivelRepositorio.save(nivel);
            return "Nivel agregado correctamente";
        } catch (Exception e) {
            throw new RuntimeException("Algo salió mal: " + e.getMessage());
        }
    }
}
