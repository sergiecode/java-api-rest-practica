package com.curso.java.apirest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Este archivo define la clase principal de una aplicación Spring Boot, que se inicia utilizando 
// SpringApplication.run(). La anotación @SpringBootApplication proporciona la configuración 
// y la funcionalidad básica para que la aplicación Spring Boot se ejecute correctamente.

@SpringBootApplication
public class ApirestApplication {

    public static void main(String[] args) {

        SpringApplication.run(ApirestApplication.class, args);
    }

}
