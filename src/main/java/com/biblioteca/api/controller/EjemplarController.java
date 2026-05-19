package com.biblioteca.api.controller;

import com.biblioteca.api.dto.ejemplar.EjemplarRequest;
import com.biblioteca.api.dto.ejemplar.EjemplarResponse;
import com.biblioteca.api.service.EjemplarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ejemplares")
public class EjemplarController {

    private final EjemplarService ejemplarService;

    @Autowired
    public EjemplarController(EjemplarService ejemplarService) {
        this.ejemplarService = ejemplarService;
    }

    @PostMapping
    public ResponseEntity<EjemplarResponse> crearEjemplar(@RequestBody EjemplarRequest request) {
        return ResponseEntity.ok(ejemplarService.crearEjemplar(request));
    }

    @PutMapping("/{codigoEjemplar}")
    public ResponseEntity<EjemplarResponse> actualizarEjemplar(@PathVariable String codigoEjemplar, @RequestBody EjemplarRequest request) {
        return ResponseEntity.ok(ejemplarService.actualizarEjemplar(codigoEjemplar, request));
    }

    @GetMapping
    public ResponseEntity<List<EjemplarResponse>> listarEjemplares() {
        return ResponseEntity.ok(ejemplarService.listarEjemplares());
    }

    @GetMapping("/{codigoEjemplar}")
    public ResponseEntity<EjemplarResponse> consultarEjemplar(@PathVariable String codigoEjemplar) {
        return ResponseEntity.ok(ejemplarService.consultarEjemplar(codigoEjemplar));
    }

    @DeleteMapping("/{codigoEjemplar}")
    public ResponseEntity<Void> eliminarEjemplar(@PathVariable String codigoEjemplar) {
        ejemplarService.eliminarEjemplar(codigoEjemplar);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{codigoEjemplar}/marcar-disponible")
    public ResponseEntity<Void> marcarDisponible(@PathVariable String codigoEjemplar) {
        ejemplarService.marcarDisponible(codigoEjemplar);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{codigoEjemplar}/marcar-prestado")
    public ResponseEntity<Void> marcarPrestado(@PathVariable String codigoEjemplar) {
        ejemplarService.marcarPrestado(codigoEjemplar);
        return ResponseEntity.ok().build();
    }
}

