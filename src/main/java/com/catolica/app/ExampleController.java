package com.catolica.app;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController 
public class ExampleController {
 @GetMapping("/erick")
 public String obtenerSaludo() {
     return new String("Hola Erick, bienvenido a Spring Boot!");
 }
    
}