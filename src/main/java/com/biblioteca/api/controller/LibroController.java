package com.biblioteca.api.controller;

import com.biblioteca.api.dto.libro.LibroRequest;
import com.biblioteca.api.dto.libro.LibroResponse;
import com.biblioteca.api.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/libros")
public class LibroController {

    private final LibroService libroService;

    @Autowired
    public LibroController(LibroService libroService) {
        this.libroService = libroService;
    }

    @PostMapping
    public ResponseEntity<LibroResponse> crearLibro(@RequestBody LibroRequest request) {
        return ResponseEntity.ok(libroService.crearLibro(request));
    }

    @PutMapping("/{isbn}")
    public ResponseEntity<LibroResponse> actualizarLibro(@PathVariable String isbn, @RequestBody LibroRequest request) {
        return ResponseEntity.ok(libroService.actualizarLibro(isbn, request));
    }

    @GetMapping
    public ResponseEntity<List<LibroResponse>> listarLibros() {
        return ResponseEntity.ok(libroService.listarLibros());
    }

    @GetMapping("/{isbn}")
    public ResponseEntity<LibroResponse> consultarLibro(@PathVariable String isbn) {
        return ResponseEntity.ok(libroService.consultarLibro(isbn));
    }

    @DeleteMapping("/{isbn}")
    public ResponseEntity<Void> eliminarLibro(@PathVariable String isbn) {
        libroService.eliminarLibro(isbn);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{isbn}/disponibilidad")
    public ResponseEntity<Void> consultarDisponibilidad(@PathVariable String isbn) {
        libroService.consultarDisponibilidad(isbn);
        return ResponseEntity.ok().build();
    }
}

