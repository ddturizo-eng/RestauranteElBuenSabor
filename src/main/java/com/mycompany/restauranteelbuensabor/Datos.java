package com.mycompany.restauranteelbuensabor;

import com.mycompany.restauranteelbuensabor.modelo.Pedido;

/**
 * Acceso centralizado al estado global del sistema.
 * Proporciona acceso al pedido activo y al contador de facturas.
 * Solo debe haber una instancia de esta clase durante toda la ejecución.
 */
public class Datos {

    /** Pedido actualmente activo en el sistema */
    public static Pedido pedidoActual = new Pedido();
    /** Contador de facturas, se incrementa después de cada factura impresa */
    public static int numeroFactura = 1;
}