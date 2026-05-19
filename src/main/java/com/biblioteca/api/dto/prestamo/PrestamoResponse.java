package com.biblioteca.api.dto.prestamo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class PrestamoResponse {

    private String id;
    private Date fechaPrestamo;
    private Date fechaDevolucionEsperada;
    private Date fechaDevolucionReal;
    private String estado;

    public PrestamoResponse() {
    }

    public PrestamoResponse(String id, Date fechaPrestamo, Date fechaDevolucionEsperada, Date fechaDevolucionReal, String estado) {
        this.id = id;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucionEsperada = fechaDevolucionEsperada;
        this.fechaDevolucionReal = fechaDevolucionReal;
        this.estado = estado;
    }
}

