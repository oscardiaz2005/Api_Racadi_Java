package com.Racadi.Academy.Racadi_Academy.Repositorios;

import com.Racadi.Academy.Racadi_Academy.Entidades.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface RepositorioProfesor extends JpaRepository<Profesor,String> {
    boolean existsByDocumento(String documento);
    List<Profesor> findByNombreContainingIgnoreCase(String nombre);

    @Query("SELECT p.nombre FROM Profesor p WHERE p.documento = :documento")
    Optional<String> findNombreByDocumento(@Param("documento") String documento);
}
