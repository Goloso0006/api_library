package com.biblioteca.api.dto.usuario;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
public class EstudianteResponse extends UsuarioResponse {

    private String codigoEstudiante;
    private String programa;

    public EstudianteResponse() {
    }

    public EstudianteResponse(String id, String nombre, String correo, String codigoEstudiante, String programa) {
        super(id, nombre, correo);
        this.codigoEstudiante = codigoEstudiante;
        this.programa = programa;
    }
}

