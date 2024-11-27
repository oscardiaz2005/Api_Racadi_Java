package com.Racadi.Academy.Racadi_Academy.Repositorios;

import com.Racadi.Academy.Racadi_Academy.Entidades.Administrador;
import org.springframework.data.jpa.repository.JpaRepository;



public interface RepositorioAdmin extends JpaRepository<Administrador,String> {
}
