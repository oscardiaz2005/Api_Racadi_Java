package com.Racadi.Academy.Racadi_Academy.Repositorios;

import com.Racadi.Academy.Racadi_Academy.Entidades.Clase;
import com.Racadi.Academy.Racadi_Academy.Entidades.Sede;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RepositorioClase extends JpaRepository<Clase,String> {
    List<Clase> findBySedeAndNivel(Sede sede, String nivel);
}
