package com.biblioteca.api.repository;

import com.biblioteca.api.model.Libro;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface LibroRepository extends MongoRepository<Libro, String> {
    Optional<Libro> findByIsbn(String isbn);
    List<Libro> findByAutorContainingIgnoreCase(String autor);
    List<Libro> findByCategoria(String categoria);
}

