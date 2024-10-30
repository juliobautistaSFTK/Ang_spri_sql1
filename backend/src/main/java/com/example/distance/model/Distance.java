package com.example.distance.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Distance {
    @Id
    private int clave;
    private String descripcion;

    // Getters y Setters
    public int getClave() { return clave; }
    public void setClave(int clave) { this.clave = clave; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
}
