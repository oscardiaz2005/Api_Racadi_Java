package com.Racadi.Academy.Racadi_Academy.Repositorios;

import com.Racadi.Academy.Racadi_Academy.Entidades.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReservaRepositorio extends JpaRepository<Reserva, Long> {
    List<Reserva> findByDocumentoEstudiante(String documentoEstudiante);
    Optional<Reserva> findByIdClaseAndDocumentoEstudiante(Long idClase, String documentoEstudiante);
}