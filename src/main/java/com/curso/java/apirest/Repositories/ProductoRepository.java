package com.curso.java.apirest.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curso.java.apirest.Entities.Producto;

// Este archivo define una interfaz que permite realizar operaciones CRUD en la entidad Producto 
// utilizando métodos proporcionados por Spring Data JPA, lo que facilita la interacción 
// con la base de datos en una aplicación Spring Boot.

public interface ProductoRepository extends JpaRepository<Producto, Long> {
}

// JPA es una especificación estándar de Java que proporciona un conjunto de interfaces y herramientas 
// para facilitar el desarrollo de aplicaciones Java que interactúan con bases de datos relacionales 
// de manera eficiente y coherente.