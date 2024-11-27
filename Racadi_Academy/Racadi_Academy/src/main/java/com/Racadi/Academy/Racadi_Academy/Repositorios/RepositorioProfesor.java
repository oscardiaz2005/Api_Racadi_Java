package com.Racadi.Academy.Racadi_Academy.Repositorios;

import com.Racadi.Academy.Racadi_Academy.Entidades.Profesores;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RepositorioProfesor extends JpaRepository<Profesores,String> {
    boolean existsByDocumento(String documento);
    List<Profesores> findByNombreContainingIgnoreCase(String nombre);
}
