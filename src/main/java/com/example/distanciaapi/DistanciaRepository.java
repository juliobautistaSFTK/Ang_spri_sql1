package com.example.distanciaapi;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DistanciaRepository extends JpaRepository<Distancia, Integer> {
    Distancia findByClave(int clave);
}
