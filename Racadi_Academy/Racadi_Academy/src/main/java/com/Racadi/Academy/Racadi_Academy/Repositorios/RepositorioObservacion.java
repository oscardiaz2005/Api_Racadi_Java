package com.Racadi.Academy.Racadi_Academy.Repositorios;

import com.Racadi.Academy.Racadi_Academy.Entidades.Observacion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RepositorioObservacion extends JpaRepository<Observacion,String> {
    List<Observacion> findByEstudianteDocumento(String documento);
}
