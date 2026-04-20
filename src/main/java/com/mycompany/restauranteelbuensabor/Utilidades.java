package com.mycompany.restauranteelbuensabor;

import com.mycompany.restauranteelbuensabor.constantes.ConfigRestaurante;

/**
 * Proporciona funciones utilitarias del sistema.
 * Incluye métodos de cálculo legacy y helpers para el estado del pedido.
 */
public class Utilidades {

    /**
     * Método de cálculo legacy mantido por compatibilidad.
     * Realiza cálculos de precio con descuento, IVA y propina.
     * 
     * @deprecated Este método está obsoleto. Usar CalculadoraFactura en su lugar.
     * @param pr precio unitario
     * @param cn cantidad
     * @param dc descuento (0-1)
     * @param iv tasa IVA (0-1)
     * @param pp tasa propina (0-1)
     * @param ni no usado
     * @param ap aplicar propina
     * @return total calculado
     */
    @Deprecated
    public static double calcular(double pr, double cn, double dc, double iv, double pp, int ni, boolean ap) {
        double res = pr * cn;

        if (dc > 0) {
            res = res - (res * dc);
        }

        double iva = res * iv;
        res = res + iva;

        if (ap) {
            res = res + (res * pp);
        }

        System.out.println(ConfigRestaurante.NOMBRE + " - calculo aplicado");

        return res;
    }

    /**
     * Verifica si el pedido actual tiene productos.
     *
     * @return true si hay al menos un producto en el pedido
     */
    public static boolean hayProductosEnPedido() {
        return Datos.pedidoActual.tieneProductos();
    }

    /**
     * Reinicia el pedido actual para una nueva orden.
     * Limpia todos los items y reinicia el estado de la mesa.
     */
    public static void reiniciar() {
        Datos.pedidoActual.limpiar();
    }
}