package com.biblioteca.api.service.impl;

import com.biblioteca.api.dto.ejemplar.EjemplarRequest;
import com.biblioteca.api.dto.ejemplar.EjemplarResponse;
import com.biblioteca.api.model.Ejemplar;
import com.biblioteca.api.repository.EjemplarRepository;
import com.biblioteca.api.service.EjemplarService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EjemplarServiceImpl implements EjemplarService {

    private final EjemplarRepository ejemplarRepository;

    public EjemplarServiceImpl(EjemplarRepository ejemplarRepository) {
        this.ejemplarRepository = ejemplarRepository;
    }

    @Override
    public EjemplarResponse crearEjemplar(EjemplarRequest request) {
        Ejemplar ejemplar = new Ejemplar();
        ejemplar.setCodigoEjemplar(request.getCodigoEjemplar());
        ejemplar.setEstado(request.getEstado());
        ejemplar.setUbicacion(request.getUbicacion());

        return mapToResponse(ejemplarRepository.save(ejemplar));
    }

    @Override
    public EjemplarResponse actualizarEjemplar(String codigoEjemplar, EjemplarRequest request) {
        Ejemplar ejemplar = ejemplarRepository.findById(codigoEjemplar)
                .orElseThrow(() -> new RuntimeException("Ejemplar no encontrado con código: " + codigoEjemplar));

        ejemplar.setEstado(request.getEstado());
        ejemplar.setUbicacion(request.getUbicacion());

        return mapToResponse(ejemplarRepository.save(ejemplar));
    }

    @Override
    public void marcarDisponible(String codigoEjemplar) {
        Ejemplar ejemplar = ejemplarRepository.findById(codigoEjemplar)
                .orElseThrow(() -> new RuntimeException("Ejemplar no encontrado con código: " + codigoEjemplar));
        ejemplar.setEstado("Disponible");
        ejemplarRepository.save(ejemplar);
    }

    @Override
    public void marcarPrestado(String codigoEjemplar) {
        Ejemplar ejemplar = ejemplarRepository.findById(codigoEjemplar)
                .orElseThrow(() -> new RuntimeException("Ejemplar no encontrado con código: " + codigoEjemplar));
        ejemplar.setEstado("Prestado");
        ejemplarRepository.save(ejemplar);
    }

    @Override
    public void eliminarEjemplar(String codigoEjemplar) {
        if (!ejemplarRepository.existsById(codigoEjemplar)) {
            throw new RuntimeException("Ejemplar no encontrado con código: " + codigoEjemplar);
        }
        ejemplarRepository.deleteById(codigoEjemplar);
    }

    @Override
    public EjemplarResponse consultarEjemplar(String codigoEjemplar) {
        return ejemplarRepository.findById(codigoEjemplar)
                .map(this::mapToResponse)
                .orElseThrow(() -> new RuntimeException("Ejemplar no encontrado con código: " + codigoEjemplar));
    }

    @Override
    public List<EjemplarResponse> listarEjemplares() {
        return ejemplarRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    private EjemplarResponse mapToResponse(Ejemplar ejemplar) {
        return new EjemplarResponse(
                ejemplar.getCodigoEjemplar(),
                ejemplar.getEstado(),
                ejemplar.getUbicacion()
        );
    }
}


