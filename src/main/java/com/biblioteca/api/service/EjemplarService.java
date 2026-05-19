package com.biblioteca.api.service;

import com.biblioteca.api.dto.ejemplar.EjemplarRequest;
import com.biblioteca.api.dto.ejemplar.EjemplarResponse;

import java.util.List;

public interface EjemplarService {

    EjemplarResponse crearEjemplar(EjemplarRequest request);

    EjemplarResponse actualizarEjemplar(String codigoEjemplar, EjemplarRequest request);

    void marcarDisponible(String codigoEjemplar);

    void marcarPrestado(String codigoEjemplar);

    void eliminarEjemplar(String codigoEjemplar);

    EjemplarResponse consultarEjemplar(String codigoEjemplar);

    List<EjemplarResponse> listarEjemplares();
}


