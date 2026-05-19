package com.biblioteca.api.service.impl;

import com.biblioteca.api.dto.prestamo.PrestamoRequest;
import com.biblioteca.api.dto.prestamo.PrestamoResponse;
import com.biblioteca.api.model.Prestamo;
import com.biblioteca.api.repository.PrestamoRepository;
import com.biblioteca.api.service.PrestamoService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@Service
public class PrestamoServiceImpl implements PrestamoService {

    private final PrestamoRepository prestamoRepository;

    public PrestamoServiceImpl(PrestamoRepository prestamoRepository) {
        this.prestamoRepository = prestamoRepository;
    }

    @Override
    public PrestamoResponse crearPrestamo(PrestamoRequest request) {
        Prestamo prestamo = new Prestamo();
        prestamo.setFechaPrestamo(request.getFechaPrestamo());
        prestamo.setFechaDevolucionEsperada(request.getFechaDevolucionEsperada());
        prestamo.setFechaDevolucionReal(request.getFechaDevolucionReal());
        prestamo.setEstado(request.getEstado());

        return mapToResponse(prestamoRepository.save(prestamo));
    }

    @Override
    public PrestamoResponse registrarPrestamo(PrestamoRequest request) {
        return crearPrestamo(request);
    }

    @Override
    public PrestamoResponse registrarDevolucion(String id) {
        Prestamo prestamo = prestamoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Préstamo no encontrado con id: " + id));

        prestamo.setFechaDevolucionReal(new Date());
        prestamo.setEstado("CERRADO");

        return mapToResponse(prestamoRepository.save(prestamo));
    }

    @Override
    public double calcularMora(String id) {
        Prestamo prestamo = prestamoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Préstamo no encontrado con id: " + id));

        if (prestamo.getFechaDevolucionEsperada() == null) {
            return 0.0;
        }

        Date fechaReferencia = prestamo.getFechaDevolucionReal() != null ? prestamo.getFechaDevolucionReal() : new Date();
        long diferenciaMillis = fechaReferencia.getTime() - prestamo.getFechaDevolucionEsperada().getTime();

        if (diferenciaMillis <= 0) {
            return 0.0;
        }

        return (double) TimeUnit.MILLISECONDS.toDays(diferenciaMillis);
    }

    @Override
    public void cerrarPrestamo(String id) {
        Prestamo prestamo = prestamoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Préstamo no encontrado con id: " + id));

        prestamo.setFechaDevolucionReal(new Date());
        prestamo.setEstado("CERRADO");
        prestamoRepository.save(prestamo);
    }

    @Override
    public PrestamoResponse actualizarPrestamo(String id, PrestamoRequest request) {
        Prestamo prestamo = prestamoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Préstamo no encontrado con id: " + id));

        prestamo.setFechaPrestamo(request.getFechaPrestamo());
        prestamo.setFechaDevolucionEsperada(request.getFechaDevolucionEsperada());
        prestamo.setFechaDevolucionReal(request.getFechaDevolucionReal());
        prestamo.setEstado(request.getEstado());

        return mapToResponse(prestamoRepository.save(prestamo));
    }

    @Override
    public void eliminarPrestamo(String id) {
        if (!prestamoRepository.existsById(id)) {
            throw new RuntimeException("Préstamo no encontrado con id: " + id);
        }
        prestamoRepository.deleteById(id);
    }

    @Override
    public PrestamoResponse consultarPrestamo(String id) {
        return prestamoRepository.findById(id)
                .map(this::mapToResponse)
                .orElseThrow(() -> new RuntimeException("Préstamo no encontrado con id: " + id));
    }

    @Override
    public List<PrestamoResponse> listarPrestamos() {
        return prestamoRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    private PrestamoResponse mapToResponse(Prestamo prestamo) {
        return new PrestamoResponse(
                prestamo.getId(),
                prestamo.getFechaPrestamo(),
                prestamo.getFechaDevolucionEsperada(),
                prestamo.getFechaDevolucionReal(),
                prestamo.getEstado()
        );
    }
}


