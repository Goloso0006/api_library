package com.biblioteca.api.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@ToString(callSuper = true)
@Document(collection = "usuarios")
public class Bibliotecario extends Usuario {
    // Atributos privados
    private String codigoEmpleado;
    private String turno;

    // Constructor vacío
    public Bibliotecario() {
    }

    // Constructor con parámetros
    public Bibliotecario(String id, String nombre, String correo, String codigoEmpleado, String turno) {
        super(id, nombre, correo);
        this.codigoEmpleado = codigoEmpleado;
        this.turno = turno;
    }


}

