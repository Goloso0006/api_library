package com.biblioteca.api.repository;

import com.biblioteca.api.model.Ejemplar;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface EjemplarRepository extends MongoRepository<Ejemplar, String> {
    Optional<Ejemplar> findByCodigoEjemplar(String codigoEjemplar);
    List<Ejemplar> findByEstado(String estado);
    List<Ejemplar> findByUbicacion(String ubicacion);
}

