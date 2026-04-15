package com.mycompany.restauranteelbuensabor.vista;

import com.mycompany.restauranteelbuensabor.Datos;
import com.mycompany.restauranteelbuensabor.constantes.ConfigRestaurante;
import com.mycompany.restauranteelbuensabor.servicio.CalculadoraFactura;

public class FacturaView {

    private static final String SEPARADOR = "========================================";
    private static final String SEPARADOR_FINO = "----------------------------------------";

    public void mostrarCarta() {
        System.out.println(SEPARADOR);
        System.out.println("    " + ConfigRestaurante.NOMBRE);
        System.out.println("    --- NUESTRA CARTA ---");
        System.out.println(SEPARADOR);

        for (int i = 0; i < Datos.nombres.length; i++) {
            System.out.printf("%d. %-22s $%,.0f%n", (i + 1), Datos.nombres[i], Datos.precios[i]);
        }

        System.out.println(SEPARADOR);
    }

    public void mostrarPedido() {
        double subtotal = 0;

        System.out.println("--- PEDIDO ACTUAL ---");

        for (int i = 0; i < Datos.nombres.length; i++) {
            if (Datos.cantidades[i] > 0) {
                System.out.printf("%-20s x%-6d $%,.0f%n",
                        Datos.nombres[i],
                        Datos.cantidades[i],
                        (Datos.precios[i] * Datos.cantidades[i]));
                subtotal += Datos.precios[i] * Datos.cantidades[i];
            }
        }

        System.out.println("--------------------");
        System.out.printf("%-27s $%,.0f%n", "Subtotal:", subtotal);
    }

    public void imprimirFacturaCompleta() {
        CalculadoraFactura calc = new CalculadoraFactura();
        double[] resultados = calc.calcularFactura();
        double subtotal = resultados[0];
        double montoBase = resultados[1];
        double iva = resultados[2];
        double total = resultados[3];
        double prop = resultados[4];
        int cantidadItems = calc.contarItems();
        boolean tieneDescuento = calc.tieneDescuento(cantidadItems);

        System.out.println(SEPARADOR);
        imprimirEncabezado();
        System.out.printf("FACTURA No. %03d%n", Datos.numeroFactura);
        System.out.println(SEPARADOR_FINO);

        imprimirItemsFactura();

        System.out.println(SEPARADOR_FINO);
        if (tieneDescuento) {
            System.out.printf("%-27s $%,.0f%n", "Subtotal:", subtotal);
            System.out.printf("%-27s $%,.0f%n", "Descuento (5%):", subtotal - montoBase);
        }
        System.out.printf("%-27s $%,.0f%n", "Subtotal:", montoBase);
        System.out.printf("%-27s $%,.0f%n", "IVA (19%):", iva);

        if (prop > 0) {
            System.out.printf("%-27s $%,.0f%n", "Propina (10%):", prop);
        }

        System.out.println(SEPARADOR_FINO);
        System.out.printf("%-27s $%,.0f%n", "TOTAL:", total);
        System.out.println(SEPARADOR);
        System.out.println("Gracias por su visita!");
        System.out.println(ConfigRestaurante.NOMBRE + " - " + ConfigRestaurante.DIRECCION);
        System.out.println(SEPARADOR);

        Datos.numeroFactura++;
        Datos.estadoMesa = 0;
    }

    public void imprimirFacturaResumen() {
        CalculadoraFactura calc = new CalculadoraFactura();
        double[] resultados = calc.calcularFactura();
        double montoBase = resultados[1];
        double iva = resultados[2];
        double total = resultados[3];
        double prop = resultados[4];

        System.out.println(SEPARADOR);
        imprimirEncabezado();
        System.out.printf("FACTURA No. %03d (RESUMEN)%n", Datos.numeroFactura);
        System.out.println(SEPARADOR_FINO);
        System.out.printf("%-27s $%,.0f%n", "Subtotal:", montoBase);
        System.out.printf("%-27s $%,.0f%n", "IVA (19%):", iva);

        if (prop > 0) {
            System.out.printf("%-27s $%,.0f%n", "Propina (10%):", prop);
        }

        System.out.println(SEPARADOR_FINO);
        System.out.printf("%-27s $%,.0f%n", "TOTAL:", total);
        System.out.println(SEPARADOR);
    }

    private void imprimirEncabezado() {
        System.out.println("    " + ConfigRestaurante.NOMBRE);
        System.out.println("    " + ConfigRestaurante.DIRECCION);
        System.out.println("    NIT: " + ConfigRestaurante.NIT);
    }

    private void imprimirItemsFactura() {
        for (int i = 0; i < Datos.nombres.length; i++) {
            if (Datos.cantidades[i] > 0) {
                System.out.printf("%-20s x%-6d $%,.0f%n",
                        Datos.nombres[i],
                        Datos.cantidades[i],
                        (Datos.precios[i] * Datos.cantidades[i]));
            }
        }
    }

    public void imprimirErrorSinProductos() {
        System.out.println("No hay productos en el pedido actual.");
        System.out.println("Use la opcion 2 para agregar productos.");
    }

    public void imprimirErrorFactura() {
        System.out.println("No se puede generar factura.");
        System.out.println("No hay productos en el pedido.");
        System.out.println("Use la opcion 2 para agregar productos primero.");
    }
}
