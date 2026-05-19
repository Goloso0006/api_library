package com.biblioteca.api.dto.usuario;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UsuarioResponse {

    private String id;
    private String nombre;
    private String correo;

    public UsuarioResponse() {
    }

    public UsuarioResponse(String id, String nombre, String correo) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
    }
}

