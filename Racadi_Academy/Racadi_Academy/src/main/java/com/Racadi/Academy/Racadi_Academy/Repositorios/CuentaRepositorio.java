package com.Racadi.Academy.Racadi_Academy.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.Racadi.Academy.Racadi_Academy.Entidades.Cuenta;


@Repository
public interface CuentaRepositorio extends JpaRepository<Cuenta, Long> {
}
