package com.biblioteca.api.dto.usuario;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
public class BibliotecarioResponse extends UsuarioResponse {

    private String codigoEmpleado;
    private String turno;

    public BibliotecarioResponse() {
    }

    public BibliotecarioResponse(String id, String nombre, String correo, String codigoEmpleado, String turno) {
        super(id, nombre, correo);
        this.codigoEmpleado = codigoEmpleado;
        this.turno = turno;
    }
}

