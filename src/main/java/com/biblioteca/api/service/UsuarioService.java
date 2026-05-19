package com.biblioteca.api.service;

import com.biblioteca.api.dto.usuario.UsuarioRequest;
import com.biblioteca.api.dto.usuario.UsuarioResponse;

import java.util.List;

public interface UsuarioService {

    UsuarioResponse crearUsuario(UsuarioRequest request);

    UsuarioResponse actualizarUsuario(String id, UsuarioRequest request);

    void consultarPrestamos(String usuarioId);

    void eliminarUsuario(String id);

    UsuarioResponse consultarUsuario(String id);

    List<UsuarioResponse> listarUsuarios();
}