package com.curso.java.apirest.Controllers;

import java.util.List;

import javax.swing.Spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curso.java.apirest.Entities.Producto;
import com.curso.java.apirest.Repositories.ProductoRepository;

// @RestController: Esta es una anotación de Spring que combina las anotaciones @Controller y @ResponseBody, 
// lo que significa que esta clase será un controlador REST que responderá a las solicitudes HTTP con objetos serializados en JSON.
// @RequestMapping("/productos"): Esta anotación especifica la ruta base para todos los métodos de este controlador. 
// Significa que todos los métodos de este controlador responderán a las solicitudes HTTP que comiencen con /productos.
@RestController
@RequestMapping("/productos")
public class ProductoController {
    // @Autowired private ProductoRepository productoRepository;: Esta línea utiliza la anotación 
    // @Autowired para inyectar una instancia de ProductoRepository en este controlador. 
    // Esto permite que el controlador acceda a los métodos definidos en ProductoRepository 
    // para interactuar con la base de datos.
    @Autowired
    private ProductoRepository productoRepository;

    // Este archivo define un controlador REST para la entidad Producto, 
    // que proporciona puntos finales para realizar operaciones CRUD en productos 
    // utilizando Spring Boot y JPA.

    @GetMapping
    public List<Producto> getAllProductos() {
        return productoRepository.findAll();
    }

    @PostMapping
    public Producto createProducto(@RequestBody Producto producto) {
        return productoRepository.save(producto);
    }

    @GetMapping("/{id}")
    public Producto getProductoById(@PathVariable Long id) {
        return productoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado con id: " + id));
    }

    @PutMapping("/{id}")
    public Producto updateProducto(@PathVariable Long id, @RequestBody Producto productoDetails) {
        Producto producto = productoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado con id: " + id));

        producto.setNombre(productoDetails.getNombre());
        producto.setPrecio(productoDetails.getPrecio());

        return productoRepository.save(producto);
    }

    @DeleteMapping("/{id}")
    public String deleteProducto(@PathVariable Long id) {
        Producto producto = productoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado con id: " + id));

        productoRepository.delete(producto);
        return "Producto eliminado correctamente.";
    }
}