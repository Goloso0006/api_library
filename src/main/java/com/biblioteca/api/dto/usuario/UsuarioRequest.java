package com.biblioteca.api.dto.usuario;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UsuarioRequest {

    private String nombre;
    private String correo;

    public UsuarioRequest() {
    }

    public UsuarioRequest(String nombre, String correo) {
        this.nombre = nombre;
        this.correo = correo;
    }
}

