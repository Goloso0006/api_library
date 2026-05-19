package com.biblioteca.api.service;

import com.biblioteca.api.dto.prestamo.PrestamoRequest;
import com.biblioteca.api.dto.prestamo.PrestamoResponse;

import java.util.List;

public interface PrestamoService {

    PrestamoResponse crearPrestamo(PrestamoRequest request);

    PrestamoResponse registrarPrestamo(PrestamoRequest request);

    PrestamoResponse registrarDevolucion(String id);

    double calcularMora(String id);

    void cerrarPrestamo(String id);

    PrestamoResponse actualizarPrestamo(String id, PrestamoRequest request);

    void eliminarPrestamo(String id);

    PrestamoResponse consultarPrestamo(String id);

    List<PrestamoResponse> listarPrestamos();
}


