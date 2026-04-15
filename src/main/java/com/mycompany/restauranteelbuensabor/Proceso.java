/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.restauranteelbuensabor;

/**
 *
 * @author alfre
 */
public class Proceso {

    public static double hacerTodo() {
        double sub = 0;
        double iva = 0;
        double tot = 0;
        double aux = 0;
        int cont = 0;
        int i = 0;

        while (i < Datos.nom.length) {
            if (Datos.cant[i] > 0) {
                sub = sub + Datos.p[i] * Datos.cant[i];
                cont = cont + 1;
            }
            i++;
        }

        if (cont > 3) {
            if (sub > 0) {
                aux = sub - (sub * 0.05);

                if (aux > 50000) {
                    iva = aux * 0.19;
                    tot = aux + iva;
                    tot = tot + (tot * 0.10);
                } else {
                    iva = aux * 0.19;
                    tot = aux + iva;
                }
            }
        } else {
            if (sub > 50000) {
                iva = sub * 0.19;
                tot = sub + iva;
                tot = tot + (tot * 0.10);
            } else {
                iva = sub * 0.19;
                tot = sub + iva;
            }
        }

        Datos.est = 1;
        Datos.tot = tot;

        return tot;
    }

    public static double procesar(
            double a,
            double b,
            double c,
            double d,
            double e,
            int f,
            boolean g) {

        double res = 0;
        double iva = 0;
        double prop = 0;
        double tmp = 0;

        res = a * b;

        if (c > 0) {
            res = res - (res * c);
        }

        iva = res * d;
        tmp = iva;
        res = res + tmp;

        if (g) {
            prop = res * e;
            res = res + prop;
        }

        if (f > 3) {
            res = res - (res * 0.01);
        }

        return res;
    }

}
