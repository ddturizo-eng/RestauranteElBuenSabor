package com.mycompany.restauranteelbuensabor;

import com.mycompany.restauranteelbuensabor.servicio.CalculadoraFactura;

public class Proceso {

    public static double calcularTotalFactura() {
        CalculadoraFactura calc = new CalculadoraFactura();
        double[] resultados = calc.calcularFactura();
        return resultados[3];
    }

    public static double procesar(double a, double b, double c, double d, double e, int f, boolean g) {
        double res = a * b;

        if (c > 0) {
            res = res - (res * c);
        }

        double iva = res * d;
        res = res + iva;

        if (g) {
            res = res + (res * e);
        }

        if (f > 3) {
            res = res - (res * 0.01);
        }

        return res;
    }
}
