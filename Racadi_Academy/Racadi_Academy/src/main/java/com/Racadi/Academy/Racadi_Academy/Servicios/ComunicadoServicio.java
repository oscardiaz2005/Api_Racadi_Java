package com.Racadi.Academy.Racadi_Academy.Servicios;


import com.Racadi.Academy.Racadi_Academy.Entidades.Comunicado;
import com.Racadi.Academy.Racadi_Academy.Repositorios.ComunicadoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class ComunicadoServicio {
    private final ComunicadoRepositorio comunicadoRepositorio;

    @Autowired
    public ComunicadoServicio(ComunicadoRepositorio comunicadoRepositorio) {
        this.comunicadoRepositorio = comunicadoRepositorio;
    }

    public Comunicado actualizarComunicado(int idComunicado, String titulo, String descripcion, String foto) {
        Comunicado comunicado = comunicadoRepositorio.findById(idComunicado)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Comunicado no encontrado."));

        if (titulo != null) {
            comunicado.setTitulo(titulo);
        }
        if (descripcion != null) {
            comunicado.setDescripcion(descripcion);
        }
        if (foto != null) {
            comunicado.setFoto(foto);
        }

        return comunicadoRepositorio.save(comunicado);
    }



    public List<Comunicado> obtenerTodosLosComunicados() {
        return comunicadoRepositorio.findAll();
    }

    public void eliminarComunicado(Long idComunicado) {
        Optional<Comunicado> comunicadoOptional = comunicadoRepositorio.findById(Math.toIntExact(idComunicado));

        if (comunicadoOptional.isEmpty()) {
            throw new IllegalArgumentException("Comunicado no encontrado.");
        }

        comunicadoRepositorio.delete(comunicadoOptional.get());
    }


    public Comunicado editarComunicado(Long idComunicado, String titulo, String descripcion, String foto) {
        Optional<Comunicado> comunicadoOptional = comunicadoRepositorio.findById(Math.toIntExact(idComunicado));

        if (comunicadoOptional.isEmpty()) {
            throw new IllegalArgumentException("Comunicado no encontrado.");
        }

        Comunicado comunicado = comunicadoOptional.get();

        if (titulo != null) {
            comunicado.setTitulo(titulo);
        }
        if (descripcion != null) {
            comunicado.setDescripcion(descripcion);
        }
        if (foto != null) {
            comunicado.setFoto(foto);
        }

        return comunicadoRepositorio.save(comunicado); // Guardar los cambios
    }
}
