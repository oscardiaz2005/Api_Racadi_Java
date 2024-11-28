package com.Racadi.Academy.Racadi_Academy.Repositorios;

import com.Racadi.Academy.Racadi_Academy.Entidades.Plan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioPlan extends JpaRepository<Plan,String> {
    Plan findByNombre(String nombre);
}
