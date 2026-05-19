package com.biblioteca.api.dto.ejemplar;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class EjemplarResponse {

    private String codigoEjemplar;
    private String estado;
    private String ubicacion;

    public EjemplarResponse() {
    }

    public EjemplarResponse(String codigoEjemplar, String estado, String ubicacion) {
        this.codigoEjemplar = codigoEjemplar;
        this.estado = estado;
        this.ubicacion = ubicacion;
    }
}

