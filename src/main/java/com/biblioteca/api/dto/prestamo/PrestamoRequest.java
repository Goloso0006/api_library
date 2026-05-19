package com.biblioteca.api.dto.prestamo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class PrestamoRequest {

    private Date fechaPrestamo;
    private Date fechaDevolucionEsperada;
    private Date fechaDevolucionReal;
    private String estado;

    public PrestamoRequest() {
    }

    public PrestamoRequest(Date fechaPrestamo, Date fechaDevolucionEsperada, Date fechaDevolucionReal, String estado) {
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucionEsperada = fechaDevolucionEsperada;
        this.fechaDevolucionReal = fechaDevolucionReal;
        this.estado = estado;
    }
}

