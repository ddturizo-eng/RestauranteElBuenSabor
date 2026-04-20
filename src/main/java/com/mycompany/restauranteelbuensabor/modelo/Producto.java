package com.mycompany.restauranteelbuensabor.modelo;

/**
 * Representa un producto del menú del restaurante.
 * Esta clase es inmutable: una vez creado, sus atributos no pueden cambiar.
 * Esto garantiza la integridad de los datos del menú durante toda la ejecución.
 */
public class Producto {

    private final String nombre;
    private final double precio;

    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }
}