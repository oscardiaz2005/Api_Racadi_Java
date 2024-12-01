package com.Racadi.Academy.Racadi_Academy.Repositorios;


import com.Racadi.Academy.Racadi_Academy.Entidades.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EstudianteRepositorio extends JpaRepository<Estudiante, Long> {
    Estudiante findByDocumento(String documento);
    Estudiante findByUsuario(String usuario);

    List<Estudiante> findAll();

    Optional<Estudiante> BuscarByDocumento(String documento);
}
