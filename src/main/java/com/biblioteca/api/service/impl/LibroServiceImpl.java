package com.biblioteca.api.service.impl;

import com.biblioteca.api.dto.libro.LibroRequest;
import com.biblioteca.api.dto.libro.LibroResponse;
import com.biblioteca.api.model.Libro;
import com.biblioteca.api.repository.LibroRepository;
import com.biblioteca.api.service.LibroService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LibroServiceImpl implements LibroService {

    private final LibroRepository libroRepository;

    public LibroServiceImpl(LibroRepository libroRepository) {
        this.libroRepository = libroRepository;
    }

    @Override
    public LibroResponse crearLibro(LibroRequest request) {
        Libro libro = new Libro();
        libro.setIsbn(request.getIsbn());
        libro.setTitulo(request.getTitulo());
        libro.setAutor(request.getAutor());
        libro.setAnioPublicacion(request.getAnioPublicacion());
        libro.setCategoria(request.getCategoria());

        return mapToResponse(libroRepository.save(libro));
    }

    @Override
    public LibroResponse actualizarLibro(String isbn, LibroRequest request) {
        Libro libro = libroRepository.findById(isbn)
                .orElseThrow(() -> new RuntimeException("Libro no encontrado con ISBN: " + isbn));

        libro.setTitulo(request.getTitulo());
        libro.setAutor(request.getAutor());
        libro.setAnioPublicacion(request.getAnioPublicacion());
        libro.setCategoria(request.getCategoria());

        return mapToResponse(libroRepository.save(libro));
    }

    @Override
    public void consultarDisponibilidad(String isbn) {
        Libro libro = libroRepository.findById(isbn)
                .orElseThrow(() -> new RuntimeException("Libro no encontrado con ISBN: " + isbn));
        System.out.println("Consultando disponibilidad del libro: " + libro.getTitulo());
    }

    @Override
    public void eliminarLibro(String isbn) {
        if (!libroRepository.existsById(isbn)) {
            throw new RuntimeException("Libro no encontrado con ISBN: " + isbn);
        }
        libroRepository.deleteById(isbn);
    }

    @Override
    public LibroResponse consultarLibro(String isbn) {
        return libroRepository.findById(isbn)
                .map(this::mapToResponse)
                .orElseThrow(() -> new RuntimeException("Libro no encontrado con ISBN: " + isbn));
    }

    @Override
    public List<LibroResponse> listarLibros() {
        return libroRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    private LibroResponse mapToResponse(Libro libro) {
        return new LibroResponse(
                libro.getIsbn(),
                libro.getTitulo(),
                libro.getAutor(),
                libro.getAnioPublicacion(),
                libro.getCategoria()
        );
    }
}


