package com.Racadi.Academy.Racadi_Academy.Repositorios;

import com.Racadi.Academy.Racadi_Academy.Entidades.Administrador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdministradorRepositorio  extends JpaRepository<Administrador, Long> {
    Optional<Administrador> findByAdministradorId(Long administradorId);
    Optional<Administrador> findByUsuario(String usuario);
}
