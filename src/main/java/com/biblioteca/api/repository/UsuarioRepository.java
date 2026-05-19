package com.biblioteca.api.repository;

import com.biblioteca.api.model.Bibliotecario;
import com.biblioteca.api.model.Estudiante;
import com.biblioteca.api.model.Profesor;
import com.biblioteca.api.model.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepository extends MongoRepository<Usuario, String> {

    Optional<Usuario> findByCorreo(String correo);

    List<Usuario> findByNombreContainingIgnoreCase(String nombre);

    @Query("{ '_class' : 'com.biblioteca.api.model.Estudiante' }")
    List<Estudiante> findAllEstudiantes();

    @Query("{ '_class' : 'com.biblioteca.api.model.Profesor' }")
    List<Profesor> findAllProfesores();

    @Query("{ '_class' : 'com.biblioteca.api.model.Bibliotecario' }")
    List<Bibliotecario> findAllBibliotecarios();
}

