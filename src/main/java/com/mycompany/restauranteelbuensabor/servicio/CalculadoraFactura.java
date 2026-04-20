package com.mycompany.restauranteelbuensabor.servicio;

import com.mycompany.restauranteelbuensabor.Datos;
import com.mycompany.restauranteelbuensabor.constantes.ConfigRestaurante;
import com.mycompany.restauranteelbuensabor.modelo.Pedido;

/**
 * Calcula los valores financieros de una factura del restaurante.
 * Aplica las reglas de negocio: descuento por volumen, IVA y propina.
 */
public class CalculadoraFactura {

    /**
     * Calcula todos los componentes de la factura: subtotal, descuento, IVA, propina y total.
     * El IVA se calcula sobre el monto base (después del descuento).
     * La propina se calcula sobre el monto con IVA incluido.
     *
     * @return array con [subtotal, montoBase, iva, total, propina]
     */
    public double[] calcularFactura() {
        Pedido pedido = Datos.pedidoActual;
        
        double subtotal = pedido.calcularSubtotal();
        int cantidadItems = pedido.contarItemsDiferentes();
        double montoBase = calcularMontoBase(subtotal, cantidadItems);
        double iva = montoBase * ConfigRestaurante.TASA_IVA;
        double prop = calcularPropina(montoBase, iva);
        double total = montoBase + iva + prop;

        double[] resultados = new double[5];
        resultados[0] = subtotal;
        resultados[1] = montoBase;
        resultados[2] = iva;
        resultados[3] = total;
        resultados[4] = prop;

        // Se marca el pedido como activo para evitar que se reinicie la mesa
        pedido.setActivo(true);
        return resultados;
    }

    /**
     * Aplica descuento por volumen si hay más de 3 tipos de productos diferentes.
     * Se usa > 3 (no >=) para que exactamente 3 productos no tengan descuento.
     *
     * @param subtotal el monto antes del descuento
     * @param cantidadItems tipos diferentes de productos
     * @return subtotal con descuento aplicado o sin modificar
     */
    private double calcularMontoBase(double subtotal, int cantidadItems) {
        if (cantidadItems > ConfigRestaurante.MIN_ITEMS_DESCUENTO) {
            return subtotal - (subtotal * ConfigRestaurante.TASA_DESCUENTO);
        }
        return subtotal;
    }

    /**
     * Calcula la propina solo si el subtotal supera el umbral definido.
     * La propina se aplica sobre el total con IVA, según práctica del sector.
     *
     * @param montoBase monto después de descuento
     * @param iva monto del IVA
     * @return valor de la propina o 0 si no aplica
     */
    private double calcularPropina(double montoBase, double iva) {
        double montoConIva = montoBase + iva;
        if (montoBase > ConfigRestaurante.UMBRAL_PROPINA) {
            return montoConIva * ConfigRestaurante.TASA_PROPINA;
        }
        return 0;
    }

    public int contarItems() {

        return Datos.pedidoActual.contarItemsDiferentes();
    }

    /**
     * Determina si aplica el descuento por volumen.
     *
     * @param cantidadItems tipos diferentes de productos
     * @return true si hay más de 3 tipos de productos
     */
    public boolean tieneDescuento(int cantidadItems) {

        return cantidadItems > ConfigRestaurante.MIN_ITEMS_DESCUENTO;
    }
}