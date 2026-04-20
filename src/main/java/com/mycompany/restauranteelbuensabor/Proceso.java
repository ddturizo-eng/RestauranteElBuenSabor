package com.mycompany.restauranteelbuensabor;

import com.mycompany.restauranteelbuensabor.servicio.CalculadoraFactura;

/**
 * Coordina los procesos de negocio del restaurante.
 * Proporciona una interfaz simplificada para los cálculos de factura.
 * Delega la lógica compleja a CalculadoraFactura.
 */
public class Proceso {

    /**
     * Calcula el total de la factura actual.
     *
     * @return el total de la factura con todos los impuestos y propinas
     */
    public static double calcularTotalFactura() {
        CalculadoraFactura calc = new CalculadoraFactura();
        double[] resultados = calc.calcularFactura();
        return resultados[3];
    }
}