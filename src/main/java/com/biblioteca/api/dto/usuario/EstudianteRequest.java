package com.biblioteca.api.dto.usuario;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
public class EstudianteRequest extends UsuarioRequest {

    private String codigoEstudiante;
    private String programa;

    public EstudianteRequest() {
    }

    public EstudianteRequest(String nombre, String correo, String codigoEstudiante, String programa) {
        super(nombre, correo);
        this.codigoEstudiante = codigoEstudiante;
        this.programa = programa;
    }
}

