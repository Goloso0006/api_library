package com.biblioteca.api.dto.usuario;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
public class ProfesorRequest extends UsuarioRequest {

    private String codigoProfesor;
    private String facultad;

    public ProfesorRequest() {
    }

    public ProfesorRequest(String nombre, String correo, String codigoProfesor, String facultad) {
        super(nombre, correo);
        this.codigoProfesor = codigoProfesor;
        this.facultad = facultad;
    }
}

