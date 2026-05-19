package com.biblioteca.api.repository;

import com.biblioteca.api.model.Prestamo;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Date;
import java.util.List;

public interface PrestamoRepository extends MongoRepository<Prestamo, String> {
    List<Prestamo> findByEstado(String estado);
    List<Prestamo> findByFechaPrestamoBetween(Date desde, Date hasta);
}

