package com.example.distanciaapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/distancia")
public class DistanciaController {
    @Autowired
    private DistanciaService distanciaService;

    @GetMapping("/{clave}")
    public String obtenerDescripcion(@PathVariable int clave) {
        return distanciaService.obtenerDescripcionPorClave(clave);
    }
}
