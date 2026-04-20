package com.mycompany.restauranteelbuensabor.modelo;

import java.util.Arrays;
import java.util.List;

/**
 * Representa el menú/carta del restaurante.
 * Contiene la lista inmutable de productos disponibles para ordenar.
 * Los precios están hardcodeados según el menú vigente.
 */
public class Carta {

    private static final List<Producto> PRODUCTOS = Arrays.asList(
        new Producto("Bandeja Paisa", 32000),
        new Producto("Sancocho de Gallina", 28000),
        new Producto("Arepa con Huevo", 8000),
        new Producto("Jugo Natural", 7000),
        new Producto("Gaseosa", 4500),
        new Producto("Cerveza Poker", 6000),
        new Producto("Agua Panela", 3500),
        new Producto("Arroz con Pollo", 25000)
    );

    /**
     * Obtiene la lista completa de productos del menú.
     *
     * @return lista de productos disponibles
     */
    public static List<Producto> getProductos() {
        return PRODUCTOS;
    }

    /**
     * Obtiene un producto por su índice en la carta (0-indexed).
     *
     * @param indice posición del producto en la carta
     * @return el producto o null si el índice es inválido
     */
    public static Producto getProducto(int indice) {
        if (indice >= 0 && indice < PRODUCTOS.size()) {
            return PRODUCTOS.get(indice);
        }
        return null;
    }

    /**
     * Obtiene la cantidad total de productos en la carta.
     *
     * @return número de productos disponibles
     */
    public static int getCantidadProductos() {

        return PRODUCTOS.size();
    }
}