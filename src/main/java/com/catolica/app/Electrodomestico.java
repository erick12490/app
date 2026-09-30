package com.catolica.app;

import java.math.BigDecimal;

public class Electrodomestico {
    private Long id;
    private String nombre;
    private String marca;
    private BigDecimal precio;

    public Electrodomestico() {
    }

    public Electrodomestico(Long id, String nombre, String marca, BigDecimal precio) {
        this.id = id;
        this.nombre = nombre;
        this.marca = marca;
        this.precio = precio;
    }

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

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }
}