package com.Racadi.Academy.Racadi_Academy.Repositorios;

import com.Racadi.Academy.Racadi_Academy.Entidades.Plan;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PlanRepositorio extends JpaRepository<Plan, Long> {

    // Cambia esto para obtener todos los planes y luego filtrar solo los nombres
    List<Plan> findAll();
}
