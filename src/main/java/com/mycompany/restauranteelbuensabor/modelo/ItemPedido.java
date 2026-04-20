package com.mycompany.restauranteelbuensabor.modelo;

/**
 * Representa un producto específico dentro de un pedido con su cantidad.
 * Permite calcular el subtotal de este item (precio × cantidad).
 */
public class ItemPedido {

    private final Producto producto;
    private int cantidad;

    public ItemPedido(Producto producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    /**
     * Incrementa la cantidad del producto en el pedido.
     *
     * @param cantidad cantidad adicional a agregar
     */
    public void aumentarCantidad(int cantidad) {
        this.cantidad += cantidad;
    }

    /**
     * Calcula el subtotal de este item (precio del producto × cantidad pedida).
     *
     * @return subtotal del item
     */
    public double calcularSubtotal() {

        return producto.getPrecio() * cantidad;
    }
}