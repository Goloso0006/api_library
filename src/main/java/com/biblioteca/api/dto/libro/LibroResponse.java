package com.biblioteca.api.dto.libro;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class LibroResponse {

    private String isbn;
    private String titulo;
    private String autor;
    private int anioPublicacion;
    private String categoria;

    public LibroResponse() {
    }

    public LibroResponse(String isbn, String titulo, String autor, int anioPublicacion, String categoria) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.anioPublicacion = anioPublicacion;
        this.categoria = categoria;
    }
}

