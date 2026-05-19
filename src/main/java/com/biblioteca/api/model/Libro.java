package com.biblioteca.api.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@ToString
@Document(collection = "libros")
public class Libro {
    // Atributos privados
    @Id
    private String isbn;
    private String titulo;
    private String autor;
    private int anioPublicacion;
    private String categoria;

    // Constructor vacío
    public Libro() {
    }

    // Constructor con parámetros
    public Libro(String isbn, String titulo, String autor, int anioPublicacion, String categoria) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.anioPublicacion = anioPublicacion;
        this.categoria = categoria;
    }

}

