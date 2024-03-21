package com.curso.java.apirest.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curso.java.apirest.Entities.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
}