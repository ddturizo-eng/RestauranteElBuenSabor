package com.mycompany.restauranteelbuensabor;

import com.mycompany.restauranteelbuensabor.constantes.ConfigRestaurante;

public class Utilidades {

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

    public static boolean hayProductosEnPedido() {
        int cantidadItems = 0;

        for (int i = 0; i < Datos.cantidades.length; i++) {
            if (Datos.cantidades[i] > 0) {
                cantidadItems++;
            }
        }

        if (cantidadItems == 0) {
            Datos.total = 0;
        }

        return cantidadItems > 0;
    }

    public static void reiniciar() {
        for (int i = 0; i < Datos.cantidades.length; i++) {
            Datos.cantidades[i] = 0;
        }

        Datos.total = 0;
        Datos.estadoMesa = 0;
        Datos.numeroMesa = 0;
    }
}
