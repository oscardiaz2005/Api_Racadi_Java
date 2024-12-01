package com.Racadi.Academy.Racadi_Academy.Servicios;


import com.Racadi.Academy.Racadi_Academy.Entidades.Cuenta;
import com.Racadi.Academy.Racadi_Academy.Repositorios.CuentaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CuentaServicio {

    @Autowired
    private CuentaRepositorio cuentaRepositorio;

    public Cuenta obtenerCuentaPorDocumento(String documento) {
        return cuentaRepositorio.findByDocumento(documento);
    }
}