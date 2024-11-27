package com.Racadi.Academy.Racadi_Academy.Repositorios;

import com.Racadi.Academy.Racadi_Academy.Entidades.Estudiantes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioEstudiante extends JpaRepository<Estudiantes,String> {
    Estudiantes findByDocumento(String documento);
}
