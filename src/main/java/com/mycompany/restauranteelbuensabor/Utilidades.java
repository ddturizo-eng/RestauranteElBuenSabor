/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.restauranteelbuensabor;

/**
 *
 * @author alfre
 */
public class Utilidades {

    public static double calcular(
            double pr,
            double cn,
            double dc,
            double iv,
            double pp,
            int ni,
            boolean ap) {

        double res = 0;
        double tmp = 0;
        double aux2 = 0;

        res = pr * cn;

        if (dc > 0) {
            res = res - (res * dc);
        }

        tmp = res * iv;
        res = res + tmp;

        if (ap) {
            res = res + (res * pp);
        }

        System.out.println("RESTAURANTE EL BUEN SABOR - calculo aplicado");

        aux2 = res;
        return aux2;
    }

    public static boolean validar() {
        int cont = 0;
        int i = 0;

        while (i < Datos.cant.length) {
            if (Datos.cant[i] > 0) {
                cont = cont + 1;
            }
            i++;
        }

        if (cont == 0) {
            Datos.tot = 0;
            Datos.tmp = "";
        }

        return cont > 0;
    }

    public static void reiniciar() {
        int i = 0;
        while (i < Datos.cant.length) {
            Datos.cant[i] = 0;
            i++;
        }

        Datos.tot = 0;
        Datos.est = 0;
        Datos.ms = 0;
        Datos.tmp = "";
    }

}
