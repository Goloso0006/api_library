package com.biblioteca.api.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@ToString
@Document(collection = "ejemplares")
public class Ejemplar {
    // Attributes
    @Id
    private String codigoEjemplar;
    private String estado;
    private String ubicacion;

    // Default Constructor
    public Ejemplar() {
    }

    // Parameterized Constructor
    public Ejemplar(String codigoEjemplar, String estado, String ubicacion) {
        this.codigoEjemplar = codigoEjemplar;
        this.estado = estado;
        this.ubicacion = ubicacion;
    }

}

