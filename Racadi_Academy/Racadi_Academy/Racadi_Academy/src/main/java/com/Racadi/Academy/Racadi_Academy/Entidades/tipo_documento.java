package com.Racadi.Academy.Racadi_Academy.Entidades;

public enum tipo_documento {
    tarjeta_identidad("Tarjeda de identidad"),
    cedula_ciudadania("Cedula de ciudadania"),
    cedula_extranjera("Cedula Extranjera");

    private String documento;

    tipo_documento(String documento) {
        this.documento = documento;
    }

    public String getDocumento() {
        return documento;
    }

}
