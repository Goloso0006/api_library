package com.biblioteca.api.dto.usuario;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
public class ProfesorResponse extends UsuarioResponse {

    private String codigoProfesor;
    private String facultad;

    public ProfesorResponse() {
    }

    public ProfesorResponse(String id, String nombre, String correo, String codigoProfesor, String facultad) {
        super(id, nombre, correo);
        this.codigoProfesor = codigoProfesor;
        this.facultad = facultad;
    }
}

