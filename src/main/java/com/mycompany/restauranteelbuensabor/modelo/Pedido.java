package com.mycompany.restauranteelbuensabor.modelo;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa un pedido activo en el restaurante.
 * Contiene la lista de productos solicitados, el número de mesa y el estado del pedido.
 * Esta clase encapsula toda la lógica relacionada con la gestión del pedido.
 */
public class Pedido {

    private final List<ItemPedido> items = new ArrayList<>();
    private int numeroMesa;
    private boolean activo;

    /**
     * Agrega un producto al pedido. Si el producto ya existe, incrementa la cantidad.
     *
     * @param producto el producto a agregar
     * @param cantidad la cantidad del producto
     */
    public void agregarItem(Producto producto, int cantidad) {
        for (ItemPedido item : items) {
            if (item.getProducto().getNombre().equals(producto.getNombre())) {
                item.aumentarCantidad(cantidad);
                return;
            }
        }
        items.add(new ItemPedido(producto, cantidad));
    }

    /**
     * Calcula el subtotal del pedido (suma de precio × cantidad de cada item).
     *
     * @return el subtotal sin impuestos
     */
    public double calcularSubtotal() {
        double subtotal = 0;
        for (ItemPedido item : items) {
            subtotal += item.calcularSubtotal();
        }
        return subtotal;
    }

    /**
     * Cuenta la cantidad de tipos diferentes de productos en el pedido.
     * Se usa para determinar si aplica el descuento por volumen.
     *
     * @return cantidad de productos diferentes
     */
    public int contarItemsDiferentes() {
        return items.size();
    }

    /**
     * Verifica si el pedido tiene productos.
     *
     * @return true si hay al menos un producto en el pedido
     */
    public boolean tieneProductos() {
        return !items.isEmpty();
    }

    public List<ItemPedido> getItems() {
        return new ArrayList<>(items);
    }

    public int getNumeroMesa() {
        return numeroMesa;
    }

    public void setNumeroMesa(int numeroMesa) {
        this.numeroMesa = numeroMesa;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    /**
     * Limpia el pedido para iniciar una nueva orden.
     * Elimina todos los items y reinicia el estado de la mesa.
     */
    public void limpiar() {
        items.clear();
        activo = false;
        numeroMesa = 0;
    }
}