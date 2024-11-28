package com.Racadi.Academy.Racadi_Academy.DTOS;

import java.util.Date;

public class ObservacionDTO {
    private Date fecha;
    private String descripcion;
    private String creadaPor;
    private String documento;

    public ObservacionDTO(Date fecha, String descripcion, String creadaPor, String documento) {
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.creadaPor = creadaPor;
        this.documento = documento;
    }

    // Getters y Setters
    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCreadaPor() {
        return creadaPor;
    }

    public void setCreadaPor(String creadaPor) {
        this.creadaPor = creadaPor;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }
}
