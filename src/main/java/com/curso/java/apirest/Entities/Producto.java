package com.curso.java.apirest.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

// Esta es la anotación que marca esta clase como una entidad JPA. 
// Indica que objetos de esta clase serán mapeados a registros de una tabla en la base de datos.
@Entity
public class Producto {

    // @Id: Esta anotación marca el campo id como la clave primaria de la entidad.
    // @GeneratedValue: Esta anotación especifica que los valores de la clave
    // primaria se generarán automáticamente por la base de datos utilizando la
    // estrategia de identidad.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private double precio;

    // este archivo define una clase de entidad llamada Producto, que representa una
    // tabla en la base de datos y contiene campos para el id, nombre y precio de un
    // producto. Esta clase está marcada con anotaciones JPA para facilitar el mapeo
    // objeto-relacional y la persistencia de datos en la base de datos.

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

}
