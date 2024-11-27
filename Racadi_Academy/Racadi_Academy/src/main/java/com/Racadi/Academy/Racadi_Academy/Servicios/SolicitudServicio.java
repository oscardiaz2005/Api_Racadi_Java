package com.Racadi.Academy.Racadi_Academy.Servicios;

import com.Racadi.Academy.Racadi_Academy.Entidades.Solicitud;
import com.Racadi.Academy.Racadi_Academy.Repositorios.RepositorioSolicitud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SolicitudServicio {


    @Autowired
    private RepositorioSolicitud repositorioSolicitud;

    public Solicitud agregar (Solicitud soli) {
        return repositorioSolicitud.save(soli);
    }
}
