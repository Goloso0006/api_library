package com.biblioteca.api.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
public class Estudiante extends Usuario {
    // Atributos privados
    private String codigoEstudiante;
    private String programa;
    // Atributos implícitos en el constructor

    // Constructor vacío
    public Estudiante() {
    }

    // Constructor con parámetros
    public Estudiante(String id, String nombre, String correo, String codigoEstudiante, String programa) {
        super(id, nombre, correo);
        this.codigoEstudiante = codigoEstudiante;
        this.programa = programa;
    }

}
