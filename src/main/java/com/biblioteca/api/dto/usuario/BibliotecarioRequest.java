package com.biblioteca.api.dto.usuario;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
public class BibliotecarioRequest extends UsuarioRequest {

    private String codigoEmpleado;
    private String turno;

    public BibliotecarioRequest() {
    }

    public BibliotecarioRequest(String nombre, String correo, String codigoEmpleado, String turno) {
        super(nombre, correo);
        this.codigoEmpleado = codigoEmpleado;
        this.turno = turno;
    }
}

