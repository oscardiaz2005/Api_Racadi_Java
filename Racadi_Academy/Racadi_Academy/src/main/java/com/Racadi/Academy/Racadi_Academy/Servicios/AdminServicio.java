package com.Racadi.Academy.Racadi_Academy.Servicios;


import com.Racadi.Academy.Racadi_Academy.Entidades.Administrador;
import com.Racadi.Academy.Racadi_Academy.Repositorios.RepositorioAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServicio {
@Autowired
    private RepositorioAdmin repositorioAdmin;



public Administrador agregar(Administrador admin){

    return repositorioAdmin.save(admin);
}


public List<Administrador> listaAdministradores(){

    return repositorioAdmin.findAll();
}


    // Método para actualizar un administrador
    public Administrador actualizarAdmin(String documento, Administrador admin) {
        // Buscamos si el administrador existe
        return repositorioAdmin.findById(documento).map(administradorExistente -> {
            administradorExistente.setUsuario(admin.getUsuario());
            administradorExistente.setContrasena(admin.getContrasena());
            return repositorioAdmin.save(administradorExistente);
        }).orElseThrow(() -> new RuntimeException("Administrador no encontrado con documento: " + documento));
    }

    // Método para eliminar un administrador
    public void eliminarAdmin(String documento) {
        repositorioAdmin.deleteById(documento);
    }
}


