package com.biblioteca.api.service;

import com.biblioteca.api.dto.libro.LibroRequest;
import com.biblioteca.api.dto.libro.LibroResponse;

import java.util.List;

public interface LibroService {

    LibroResponse crearLibro(LibroRequest request);

    LibroResponse actualizarLibro(String isbn, LibroRequest request);

    void consultarDisponibilidad(String isbn);

    void eliminarLibro(String isbn);

    LibroResponse consultarLibro(String isbn);

    List<LibroResponse> listarLibros();
}


