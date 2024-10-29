package com.example.distanciaapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DistanciaService {
    @Autowired
    private DistanciaRepository distanciaRepository;

    public String obtenerDescripcionPorClave(int clave) {
        Distancia distancia = distanciaRepository.findByClave(clave);
        return distancia != null ? distancia.getDescripcion() : "Descripción no encontrada";
    }
}
