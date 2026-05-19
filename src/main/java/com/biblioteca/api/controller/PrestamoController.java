package com.biblioteca.api.controller;

import com.biblioteca.api.dto.prestamo.PrestamoRequest;
import com.biblioteca.api.dto.prestamo.PrestamoResponse;
import com.biblioteca.api.service.PrestamoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/prestamos")
public class PrestamoController {

    private final PrestamoService prestamoService;

    @Autowired
    public PrestamoController(PrestamoService prestamoService) {
        this.prestamoService = prestamoService;
    }

    @PostMapping
    public ResponseEntity<PrestamoResponse> crearPrestamo(@RequestBody PrestamoRequest request) {
        return ResponseEntity.ok(prestamoService.crearPrestamo(request));
    }

    @PostMapping("/registrar")
    public ResponseEntity<PrestamoResponse> registrarPrestamo(@RequestBody PrestamoRequest request) {
        return ResponseEntity.ok(prestamoService.registrarPrestamo(request));
    }

    @PostMapping("/{id}/devolucion")
    public ResponseEntity<PrestamoResponse> registrarDevolucion(@PathVariable String id) {
        return ResponseEntity.ok(prestamoService.registrarDevolucion(id));
    }

    @GetMapping("/{id}/mora")
    public ResponseEntity<Double> calcularMora(@PathVariable String id) {
        return ResponseEntity.ok(prestamoService.calcularMora(id));
    }

    @PostMapping("/{id}/cerrar")
    public ResponseEntity<Void> cerrarPrestamo(@PathVariable String id) {
        prestamoService.cerrarPrestamo(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<PrestamoResponse> actualizarPrestamo(@PathVariable String id, @RequestBody PrestamoRequest request) {
        return ResponseEntity.ok(prestamoService.actualizarPrestamo(id, request));
    }

    @GetMapping
    public ResponseEntity<List<PrestamoResponse>> listarPrestamos() {
        return ResponseEntity.ok(prestamoService.listarPrestamos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PrestamoResponse> consultarPrestamo(@PathVariable String id) {
        return ResponseEntity.ok(prestamoService.consultarPrestamo(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPrestamo(@PathVariable String id) {
        prestamoService.eliminarPrestamo(id);
        return ResponseEntity.noContent().build();
    }
}

