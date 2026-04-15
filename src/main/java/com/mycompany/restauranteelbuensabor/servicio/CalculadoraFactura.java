package com.mycompany.restauranteelbuensabor.servicio;

import com.mycompany.restauranteelbuensabor.Datos;
import com.mycompany.restauranteelbuensabor.constantes.ConfigRestaurante;

public class CalculadoraFactura {

    public double[] calcularFactura() {
        double[] resultados = new double[4];
        double subtotal = calcularSubtotal();
        int cantidadItems = contarItems();
        double montoBase = calcularMontoBase(subtotal, cantidadItems);
        double iva = montoBase * ConfigRestaurante.TASA_IVA;
        double prop = calcularPropina(montoBase, iva);
        double total = montoBase + iva + prop;

        resultados[0] = subtotal;
        resultados[1] = montoBase;
        resultados[2] = iva;
        resultados[3] = total;
        resultados = expandirArray(resultados, prop);

        Datos.estadoMesa = 1;
        Datos.total = total;

        return resultados;
    }

    private double calcularSubtotal() {
        double subtotal = 0;
        for (int i = 0; i < Datos.nombres.length; i++) {
            if (Datos.cantidades[i] > 0) {
                subtotal += Datos.precios[i] * Datos.cantidades[i];
            }
        }
        return subtotal;
    }

    public int contarItems() {
        int cantidad = 0;
        for (int i = 0; i < Datos.nombres.length; i++) {
            if (Datos.cantidades[i] > 0) {
                cantidad++;
            }
        }
        return cantidad;
    }

    private double calcularMontoBase(double subtotal, int cantidadItems) {
        if (cantidadItems > ConfigRestaurante.MIN_ITEMS_DESCUENTO) {
            return subtotal - (subtotal * ConfigRestaurante.TASA_DESCUENTO);
        }
        return subtotal;
    }

    private double calcularPropina(double montoBase, double iva) {
        double montoConIva = montoBase + iva;
        if (montoBase > ConfigRestaurante.UMBRAL_PROPINA) {
            return montoConIva * ConfigRestaurante.TASA_PROPINA;
        }
        return 0;
    }

    private double[] expandirArray(double[] original, double prop) {
        double[] nuevo = new double[5];
        for (int i = 0; i < original.length; i++) {
            nuevo[i] = original[i];
        }
        nuevo[4] = prop;
        return nuevo;
    }

    public boolean tieneDescuento(int cantidadItems) {
        return cantidadItems > ConfigRestaurante.MIN_ITEMS_DESCUENTO;
    }
}
