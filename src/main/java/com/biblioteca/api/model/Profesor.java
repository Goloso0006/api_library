package com.biblioteca.api.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@ToString(callSuper = true)
public class Profesor extends Usuario {
    // Atributos privados
    private String codigoProfesor;
    private String facultad;

    // Constructor vacío
    public Profesor() {
    }

    // Constructor con parámetros
    public Profesor(String id, String nombre, String correo, String codigoProfesor, String facultad) {
        super(id, nombre, correo);
        this.codigoProfesor = codigoProfesor;
        this.facultad = facultad;
    }

}

