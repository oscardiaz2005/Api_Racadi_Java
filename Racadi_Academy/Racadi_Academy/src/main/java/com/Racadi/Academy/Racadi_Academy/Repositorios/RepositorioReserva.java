package com.Racadi.Academy.Racadi_Academy.Repositorios;

import com.Racadi.Academy.Racadi_Academy.Entidades.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RepositorioReserva extends JpaRepository<Reserva, Long> {
    List<Reserva> findByDocumento_estudiante(String documento_estudiante);
}
