package com.mycompany.restauranteelbuensabor;

import com.mycompany.restauranteelbuensabor.constantes.ConfigRestaurante;
import com.mycompany.restauranteelbuensabor.modelo.Carta;
import com.mycompany.restauranteelbuensabor.modelo.Producto;
import com.mycompany.restauranteelbuensabor.vista.FacturaView;
import java.util.Scanner;

/**
 * Punto de entrada del sistema de facturación del restaurante.
 * Maneja el ciclo del menú principal y coordina las operaciones del sistema.
 * Esta clase es el controlador central que conecta la vista con los servicios.
 */
public class RestauranteElBuenSabor {

    private static Scanner sc;
    private static FacturaView vista;

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        vista = new FacturaView();

        int opcion;
        int intentosInvalidos = 0;

        mostrarBienvenida();

        while (true) {
            opcion = mostrarMenuYLeerOpcion();

            switch (opcion) {
                case 1:
                    verCarta();
                    break;
                case 2:
                    agregarProducto();
                    break;
                case 3:
                    verPedido();
                    break;
                case 4:
                    generarFactura();
                    break;
                case 5:
                    nuevaMesa();
                    break;
                case 0:
                    salir();
                    return;
                default:
                    intentosInvalidos = manejarOpcionInvalida(intentosInvalidos);
            }
        }
    }

    private static void mostrarBienvenida() {
        System.out.println("========================================");
        System.out.println("    " + ConfigRestaurante.NOMBRE);
        System.out.println("    " + ConfigRestaurante.DIRECCION);
        System.out.println("    NIT: " + ConfigRestaurante.NIT);
        System.out.println("========================================");
    }

    private static int mostrarMenuYLeerOpcion() {
        System.out.println("1. Ver carta");
        System.out.println("2. Agregar producto al pedido");
        System.out.println("3. Ver pedido actual");
        System.out.println("4. Generar factura");
        System.out.println("5. Nueva mesa");
        System.out.println("0. Salir");
        System.out.println("========================================");
        System.out.print("Seleccione una opcion: ");
        return sc.nextInt();
    }

    private static void verCarta() {
        System.out.println();
        vista.mostrarCarta();
        System.out.println();
    }

    private static void agregarProducto() {
        System.out.println();
        System.out.println("--- AGREGAR PRODUCTO ---");
        System.out.print("Numero de producto (1-" + Carta.getCantidadProductos() + "): ");

        int numeroProducto = sc.nextInt();
        System.out.print("Cantidad: ");
        int cantidad = sc.nextInt();

        if (numeroProducto > 0 && numeroProducto <= Carta.getCantidadProductos() && cantidad > 0) {
            inicializarMesaSiNecesario();
            Producto producto = Carta.getProducto(numeroProducto - 1);
            Datos.pedidoActual.agregarItem(producto, cantidad);
            System.out.println("Producto agregado al pedido.");
            System.out.println("  -> " + producto.getNombre() + " x" + cantidad);
        } else {
            validarEntradaProducto(numeroProducto, cantidad);
        }

        System.out.println();
    }

    private static void inicializarMesaSiNecesario() {
        if (!Datos.pedidoActual.isActivo()) {
            System.out.print("Ingrese numero de mesa: ");
            int numeroMesa = sc.nextInt();

            if (numeroMesa <= 0) {
                numeroMesa = 1;
            }
            Datos.pedidoActual.setNumeroMesa(numeroMesa);
            Datos.pedidoActual.setActivo(true);
        }
    }

    private static void validarEntradaProducto(int numeroProducto, int cantidad) {
        if (numeroProducto <= 0 || numeroProducto > Carta.getCantidadProductos()) {
            System.out.println("El numero debe estar entre 1 y " + Carta.getCantidadProductos() + ".");
        } else if (cantidad == 0) {
            System.out.println("La cantidad no puede ser cero.");
        } else {
            System.out.println("Cantidad invalida. Ingrese un valor positivo.");
        }
    }

    private static void verPedido() {
        System.out.println();

        if (Utilidades.hayProductosEnPedido()) {
            vista.mostrarPedido();
        } else {
            vista.imprimirErrorSinProductos();
        }

        System.out.println();
    }

    private static void generarFactura() {
        System.out.println();

        if (Utilidades.hayProductosEnPedido()) {
            vista.imprimirFacturaCompleta();
            System.out.println();
        } else {
            vista.imprimirErrorFactura();
        }
    }

    private static void nuevaMesa() {
        System.out.println();
        Utilidades.reiniciar();
        System.out.println("Mesa reiniciada. Lista para nuevo cliente.");
        System.out.println();
    }

    private static void salir() {
        System.out.println("Hasta luego!");
        sc.close();
    }

    private static int manejarOpcionInvalida(int intentos) {
        System.out.println("Opcion no valida. Seleccione entre 0 y 5.");
        intentos++;

        if (intentos > 3) {
            System.out.println("Demasiados intentos invalidos.");
            return 0;
        }
        return intentos;
    }
}