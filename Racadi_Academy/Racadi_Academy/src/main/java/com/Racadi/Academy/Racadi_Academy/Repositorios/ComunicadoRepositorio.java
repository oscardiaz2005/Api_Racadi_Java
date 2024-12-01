package com.Racadi.Academy.Racadi_Academy.Repositorios;


import com.Racadi.Academy.Racadi_Academy.Entidades.Comunicado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
    public interface ComunicadoRepositorio extends JpaRepository<Comunicado, Integer> {
    List<Comunicado> findAll();
}


