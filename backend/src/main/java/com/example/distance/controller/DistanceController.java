package com.example.distance.controller;

import com.example.distance.model.Distance;
import com.example.distance.repository.DistanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/distancia")
public class DistanceController {

    @Autowired
    private DistanceRepository distanceRepository;

    @GetMapping("/{clave}")
    public Distance getDescripcionByClave(@PathVariable int clave) {
        return distanceRepository.findById(clave).orElse(null);
    }
}
